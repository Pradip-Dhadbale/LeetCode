import java.util.Arrays;

class Solution {
    int m, n, k;
    int[][][] memo;
    int[][] grid;
    // We MUST use this to prevent the negative number error
    int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        this.grid = grid;
        this.k = k;
        this.m = grid.length;
        this.n = grid[0].length;
        
        memo = new int[m][n][k];
        for (int[][] row : memo) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        return dfs(0, 0, 0);
    }

    private int dfs(int i, int j, int currentRem) {
        int newRem = (currentRem + grid[i][j]) % k;

        if (i == m - 1 && j == n - 1) {
            return (newRem == 0) ? 1 : 0;
        }

        if (memo[i][j][currentRem] != -1) {
            return memo[i][j][currentRem];
        }

        int count = 0;

        // Move Down
        if (i + 1 < m) {
            // Apply % MOD to keep the number within integer limits
            count = (count + dfs(i + 1, j, newRem)) % MOD;
        }

        // Move Right
        if (j + 1 < n) {
            // Apply % MOD here too
            count = (count + dfs(i, j + 1, newRem)) % MOD;
        }

        return memo[i][j][currentRem] = count;
    }
}