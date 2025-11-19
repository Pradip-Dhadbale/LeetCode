class Solution {
    /**
     * Removes duplicates from a sorted array in place, ensuring the first 
     * k elements are unique.
     * * @param nums The input array of integers (must be sorted).
     * @return The length of the array after removing duplicates (k).
     */
    public int removeDuplicates(int[] nums) {
        // Handle the edge case of an empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // The slow-runner 'i' tracks the index for the next unique element 
        // (and will be the final length k). It starts at 1 because nums[0] is unique.
        int i = 1; 

        // The fast-runner 'j' iterates through the array checking every element.
        for (int j = 1; j < nums.length; j++) {
            // Compare the current element (j) with the last recorded unique element (i-1).
            if (nums[j] != nums[i - 1]) {
                // Found a new unique element.
                
                // 1. Move the unique element to the position 'i'.
                nums[i] = nums[j];
                
                // 2. Increment 'i' to mark the next available spot for a unique element.
                i++;
            }
            // If nums[j] == nums[i - 1], the element is a duplicate. 
            // We do nothing with 'i' and let 'j' continue to the next element.
        }
        
        // 'i' holds the final length (k) of the unique elements.
        return i;
    }
}