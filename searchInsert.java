class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            // Find the middle index
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid; // Found it!
            } else if(nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
        
        // If we exit the loop, 'left' is the position where it should be inserted
        return left;
    }
}