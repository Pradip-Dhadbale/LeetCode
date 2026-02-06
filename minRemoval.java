import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxKeep = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            // Use long to prevent integer overflow during multiplication
            // Condition: max <= min * k
            while (nums[right] > (long) nums[left] * k) {
                left++;
            }
            
            maxKeep = Math.max(maxKeep, right - left + 1);
        }
        
        return n - maxKeep;
    }
}