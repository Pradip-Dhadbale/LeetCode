class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] minRow = new int[n + 1];
        int[] maxRow = new int[n + 1];
        int[] minCol = new int[n + 1];
        int[] maxCol = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            minRow[i] = Integer.MAX_VALUE;
            maxRow[i] = Integer.MIN_VALUE;
            minCol[i] = Integer.MAX_VALUE;
            maxCol[i] = Integer.MIN_VALUE;
        }
        
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];
            
            if (y < minRow[x]) minRow[x] = y;
            if (y > maxRow[x]) maxRow[x] = y;
            if (x < minCol[y]) minCol[y] = x;
            if (x > maxCol[y]) maxCol[y] = x;
        }
        
        int count = 0;
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];
            
            if (y > minRow[x] && y < maxRow[x] && x > minCol[y] && x < maxCol[y]) {
                count++;
            }
        }
        
        return count;
    }
}