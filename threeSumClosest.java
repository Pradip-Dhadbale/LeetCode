import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            
            while (l < r) {
                int curSum = nums[i] + nums[l] + nums[r];
                
                if (Math.abs(target - curSum) < Math.abs(target - closestSum)) {
                    closestSum = curSum;
                }
                
                if (curSum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        
        return closestSum;
    }
}