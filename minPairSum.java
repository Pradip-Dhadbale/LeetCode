import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        // Sort the array in ascending order
        Arrays.sort(nums);
        
        int maxPairSum = 0;
        int n = nums.length;
        
        // Iterate through the first half, pairing with the second half (reversed)
        for (int i = 0; i < n / 2; i++) {
            int currentSum = nums[i] + nums[n - 1 - i];
            maxPairSum = Math.max(maxPairSum, currentSum);
        }
        
        return maxPairSum;
    }
}