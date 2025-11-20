class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == original) {
                original = 2*original;

                i = -1;
            }
        }
        return original;
    }
}


// import java.util.Arrays;

// // class Solution {
// //     public int findFinalValue(int[] nums, int original) {
// //         // 1. Sort the array first (e.g., [5, 3, 6, 1, 12] -> [1, 3, 5, 6, 12])
// //         Arrays.sort(nums);

// //         // 2. Iterate through the sorted numbers
// //         for (int num : nums) {
// //             // 3. If we find the number we are looking for...
// //             if (num == original) {
// //                 // ...multiply original by 2.
// //                 original = 2 * original;
// //             }
// //         }
        
// //         return original;
// //     }
// // }