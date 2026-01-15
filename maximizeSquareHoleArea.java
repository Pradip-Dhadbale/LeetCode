import java.util.Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int gapH = getMaxGap(hBars);
        int gapV = getMaxGap(vBars);
        
        // The largest square side is limited by the smaller of the two max gaps
        int side = Math.min(gapH, gapV);
        
        return side * side;
    }
    
    private int getMaxGap(int[] bars) {
        Arrays.sort(bars);
        int maxConsecutive = 1;
        int currentConsecutive = 1;
        
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                currentConsecutive++;
            } else {
                currentConsecutive = 1;
            }
            maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
        }
        
        // If we remove k consecutive bars, the gap size is k + 1
        return maxConsecutive + 1;
    }
}