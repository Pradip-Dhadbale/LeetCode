import java.util.*;

class Solution {
    // 1. Fixed return type to 'int'
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        if (n < 4) return 0;

        // Map 1: Slope -> {LinePos -> Count}
        // Used to count total pairs of parallel segments
        Map<Long, Map<Long, Integer>> slopeMap = new HashMap<>();
        
        // Map 2: Midpoint -> {Slope -> Count}
        // Used to find valid parallelograms (ignoring collinear ones)
        Map<Long, Map<Long, Integer>> midMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                int g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g; 
                dy /= g;
                
                // Normalize signs
                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx; 
                    dy = -dy;
                }

                long slopeKey = ((long) dx << 32) | (dy & 0xFFFFFFFFL);
                long linePos = (long) dx * points[i][1] - (long) dy * points[i][0];
                long midKey = ((long) (points[i][0] + points[j][0]) << 32) | 
                              ((points[i][1] + points[j][1]) & 0xFFFFFFFFL);

                // Update Slope Map
                slopeMap.computeIfAbsent(slopeKey, k -> new HashMap<>())
                        .merge(linePos, 1, Integer::sum);

                // Update Midpoint Map (Tracking slope to detect collinearity)
                midMap.computeIfAbsent(midKey, k -> new HashMap<>())
                      .merge(slopeKey, 1, Integer::sum);
            }
        }

        long parallelPairs = 0;

        // Calculate Parallel Pairs
        for (Map<Long, Integer> lines : slopeMap.values()) {
            if (lines.size() < 2) continue;
            
            long totalSegments = 0;
            long currentSum = 0;
            
            // Multiply counts from different lines (e.g., Line A * Line B)
            for (int count : lines.values()) {
                currentSum += totalSegments * count;
                totalSegments += count;
            }
            parallelPairs += currentSum;
        }

        long validParallelograms = 0;

        // Calculate Parallelograms (Filtering out collinear segments)
        for (Map<Long, Integer> slopesAtMid : midMap.values()) {
            long totalSegs = 0;
            for (int count : slopesAtMid.values()) {
                totalSegs += count;
            }
            
            // All pairs of segments sharing this midpoint
            long totalPairs = totalSegs * (totalSegs - 1) / 2;
            
            // Subtract pairs that have the SAME slope (because they are just one long line)
            long collinearPairs = 0;
            for (int count : slopesAtMid.values()) {
                collinearPairs += (long) count * (count - 1) / 2;
            }
            
            validParallelograms += (totalPairs - collinearPairs);
        }

        // 2. Cast final result to int
        return (int) (parallelPairs - validParallelograms);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}