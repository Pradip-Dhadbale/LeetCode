class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        
        // If the target is larger than or equal to the largest character in the array,
        // we wrap around to the first character.
        if (target >= letters[n - 1]) {
            return letters[0];
        }
        
        int low = 0;
        int high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // We want the smallest character strictly greater than target.
            // If letters[mid] is greater, it's a candidate, but we try to find a smaller one to the left.
            if (letters[mid] > target) {
                high = mid - 1;
            } else {
                // If letters[mid] <= target, we must look to the right.
                low = mid + 1;
            }
        }
        
        return letters[low];
    }
}