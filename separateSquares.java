class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double minY = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;
        
        for (int[] sq : squares) {
            long l = sq[2];
            totalArea += l * l;
            minY = Math.min(minY, sq[1]);
            maxY = Math.max(maxY, sq[1] + l);
        }
        
        double target = totalArea / 2.0;
        double low = minY;
        double high = maxY;
        
        // Run binary search for fixed iterations to handle precision
        for (int i = 0; i < 100; i++) {
            double mid = low + (high - low) / 2;
            if (getAreaBelow(squares, mid) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        return high;
    }
    
    private double getAreaBelow(int[][] squares, double h) {
        double area = 0;
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            
            if (h <= y) {
                continue;
            } else if (h >= y + l) {
                area += l * l;
            } else {
                area += l * (h - y);
            }
        }
        return area;
    }
}