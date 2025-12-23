import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        
        // PriorityQueue stores [endTime, value], sorted by endTime
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int maxVal = 0;
        int ans = 0;
        
        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            int value = event[2];
            
            // Remove events that ended before the current event starts
            // and update the max value found so far
            while (!pq.isEmpty() && pq.peek()[0] < start) {
                maxVal = Math.max(maxVal, pq.poll()[1]);
            }
            
            // Update answer: current event value + max value of a compatible previous event
            ans = Math.max(ans, maxVal + value);
            
            // Add current event to the queue
            pq.offer(new int[]{end, value});
        }
        
        return ans;
    }
}