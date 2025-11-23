

// class Solution {
//     public int maxSumDivThree(int[] nums) {
//         Arrays.sort(nums);
        
//         int sum = 0;
//         for (int n : nums) sum += n;
        
//         int rem = sum % 3;
//         if (rem == 0) return sum;

//         int ans = 0;

//         for (int n : nums) {
//             if (n % 3 == rem) {
//                 ans = Math.max(ans, sum - n);
//                 break;
//             }
//         }

//         int targetRem = (rem == 1) ? 2 : 1;
//         int sumOfTwo = 0;
//         int count = 0;
        
//         for (int n : nums) {
//             if (n % 3 == targetRem) {
//                 sumOfTwo += n;
//                 count++;
//                 if (count == 2) {
//                     ans = Math.max(ans, sum - sumOfTwo);
//                     break; 
//                 }
//             }
//         }
        
//         return ans;
//     }
// }

import java.util.Arrays;

class Solution {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        
        int rem = sum % 3;
        
        if (rem == 0) {
            return sum;
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == rem) {
                ans = Math.max(ans, sum - nums[i]);
                break; 
            }
        }

        int targetRem;
        if (rem == 1) {
            targetRem = 2;
        } else {
            targetRem = 1;
        }
        
        int sumOfTwo = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == targetRem) {
                sumOfTwo = sumOfTwo + nums[i];
                count++;
                
                if (count == 2) {
                    ans = Math.max(ans, sum - sumOfTwo);
                    break; 
                }
            }
        }
        
        return ans;
    }
}
