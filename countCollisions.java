class Solution {
    public int countCollisions(String directions) {
        int left = 0;
        int right = directions.length() - 1;
        
        // 1. Skip all 'L' cars on the far left.
        // These cars drive away safely and hit nothing.
        while (left < directions.length() && directions.charAt(left) == 'L') {
            left++;
        }
        
        // 2. Skip all 'R' cars on the far right.
        // These cars also drive away safely.
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }
        
        // 3. Count collisions in the middle "danger zone".
        // Any car in this remaining range that is NOT stationary ('S')
        // will eventually crash into something.
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                count++;
            }
        }
        
        return count;
    }
}