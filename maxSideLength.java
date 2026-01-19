class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] P = new int[m + 1][n + 1];
        
        // 1. Build 2D Prefix Sum Array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                P[i + 1][j + 1] = P[i][j + 1] + P[i + 1][j] - P[i][j] + mat[i][j];
            }
        }
        
        int maxSide = 0;
        
        // 2. Iterate through the matrix trying to increase the square size
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // We only care if we can find a square bigger than what we already found
                int len = maxSide + 1;
                
                // Check if such a square fits within boundaries ending at (i,j)
                if (i - len + 1 >= 0 && j - len + 1 >= 0) {
                    int r1 = i - len + 1;
                    int c1 = j - len + 1;
                    
                    // Get sum of the square in O(1)
                    int sum = P[i + 1][j + 1] - P[r1][j + 1] - P[i + 1][c1] + P[r1][c1];
                    
                    if (sum <= threshold) {
                        maxSide++;
                    }
                }
            }
        }
        
        return maxSide;
    }
}