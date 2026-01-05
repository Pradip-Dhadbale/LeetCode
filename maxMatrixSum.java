class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int minAbs = Integer.MAX_VALUE;
        int negCount = 0;
        
        for (int[] row : matrix) {
            for (int val : row) {
                totalSum += Math.abs(val);
                minAbs = Math.min(minAbs, Math.abs(val));
                if (val < 0) {
                    negCount++;
                }
            }
        }
        
        if (negCount % 2 == 0) {
            return totalSum;
        } else {
            return totalSum - 2L * minAbs;
        }
    }
}