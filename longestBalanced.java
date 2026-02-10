class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        
        // Iterate over every possible starting point
        for (int i = 0; i < n; i++) {
            // Use a HashSet to track distinct elements in the current window
            Set<Integer> distinctSeen = new HashSet<>();
            int evenCnt = 0;
            int oddCnt = 0;
            
            // Extend the subarray to the right
            for (int j = i; j < n; j++) {
                int val = nums[j];
                
                // If the number is new to this window, update counts
                if (distinctSeen.add(val)) {
                    if (val % 2 == 0) {
                        evenCnt++;
                    } else {
                        oddCnt++;
                    }
                }
                
                // Check if distinct evens equal distinct odds
                if (evenCnt == oddCnt) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        
        return maxLen;
    }
}