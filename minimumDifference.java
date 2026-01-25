import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        
        // Sort the array so that the k scores in any window are as close as possible
        Arrays.sort(nums);
        
        int minDiff = Integer.MAX_VALUE;
        
        // Iterate through the array with a window of size k
        // i is the start of the window, i + k - 1 is the end
        for (int i = 0; i <= nums.length - k; i++) {
            int currentDiff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(minDiff, currentDiff);
        }
        
        return minDiff;
    }
}