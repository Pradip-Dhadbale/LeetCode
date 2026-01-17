class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxSide = 0;
        int n = bottomLeft.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                // 1. Find intersection rectangle coordinates
                // Max of the starting coordinates
                int startX = (bottomLeft[i][0] > bottomLeft[j][0]) ? bottomLeft[i][0] : bottomLeft[j][0];
                int startY = (bottomLeft[i][1] > bottomLeft[j][1]) ? bottomLeft[i][1] : bottomLeft[j][1];
                
                // Min of the ending coordinates
                int endX = (topRight[i][0] < topRight[j][0]) ? topRight[i][0] : topRight[j][0];
                int endY = (topRight[i][1] < topRight[j][1]) ? topRight[i][1] : topRight[j][1];
                
                // 2. Check if a valid intersection exists
                if (startX < endX && startY < endY) {
                    long width = endX - startX;
                    long height = endY - startY;
                    
                    // The largest square side is the smaller of width and height
                    long side = (width < height) ? width : height;
                    
                    if (side > maxSide) {
                        maxSide = side;
                    }
                }
            }
        }
        
        return maxSide * maxSide;
    }
}