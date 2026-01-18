class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rSum = new int[m][n + 1];
        int[][] cSum = new int[m + 1][n];
        
        // Build Prefix Sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rSum[i][j + 1] = rSum[i][j] + grid[i][j];
                cSum[i + 1][j] = cSum[i][j] + grid[i][j];
            }
        }
        
        // Check size k from largest to smallest
        for (int k = Math.min(m, n); k > 1; k--) {
            for (int r = 0; r <= m - k; r++) {
                nextSquare:
                for (int c = 0; c <= n - k; c++) {
                    int val = rSum[r][c + k] - rSum[r][c]; // Target sum
                    
                    // Check Rows & Cols
                    for (int i = 0; i < k; i++) {
                        if (rSum[r + i][c + k] - rSum[r + i][c] != val) continue nextSquare;
                        if (cSum[r + k][c + i] - cSum[r][c + i] != val) continue nextSquare;
                    }
                    
                    // Check Diagonals
                    int d1 = 0, d2 = 0;
                    for (int i = 0; i < k; i++) {
                        d1 += grid[r + i][c + i];
                        d2 += grid[r + i][c + k - 1 - i];
                    }
                    if (d1 == val && d2 == val) return k;
                }
            }
        }
        return 1;
    }
}