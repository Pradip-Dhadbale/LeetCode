class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                if (grid[i + 1][j + 1] != 5) continue; 
                if (isValid(grid, i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isValid(int[][] grid, int r, int c) {
        int[] freq = new int[10];
        
        // Check if numbers 1-9 are distinct
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9 || freq[val] > 0) return false;
                freq[val]++;
            }
        }
        
        // Check sums (rows, columns, diagonals)
        int row1 = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        int row3 = grid[r+2][c] + grid[r+2][c+1] + grid[r+2][c+2];
        int col1 = grid[r][c] + grid[r+1][c] + grid[r+2][c];
        int col3 = grid[r][c+2] + grid[r+1][c+2] + grid[r+2][c+2];
        int diag1 = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
        int diag2 = grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];
        
        return row1 == 15 && row3 == 15 && 
               col1 == 15 && col3 == 15 && 
               diag1 == 15 && diag2 == 15;
    }
}