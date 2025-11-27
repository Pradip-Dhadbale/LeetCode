import java.util.Arrays;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long ans = Long.MIN_VALUE;
        long currentSum = 0;
        
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);
        minPrefix[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int remainder = (i + 1) % k;

            if (minPrefix[remainder] != Long.MAX_VALUE) {
                long subarraySum = currentSum - minPrefix[remainder];
                if (subarraySum > ans) {
                    ans = subarraySum;
                }
            }

            if (currentSum < minPrefix[remainder]) {
                minPrefix[remainder] = currentSum;
            }
        }

        return ans;
    }
}