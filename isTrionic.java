class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length, i = 0;
        
        // 1. Up
        while (i < n - 1 && nums[i] < nums[i + 1]) i++;
        if (i == 0 || i == n - 1) return false;
        
        // 2. Down
        int j = i;
        while (j < n - 1 && nums[j] > nums[j + 1]) j++;
        if (j == i || j == n - 1) return false;
        
        // 3. Up
        while (j < n - 1 && nums[j] < nums[j + 1]) j++;
        
        return j == n - 1;
    }
}