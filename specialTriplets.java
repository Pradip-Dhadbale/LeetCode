import java.util.HashMap;
import java.util.Map;

class Solution {
    public int specialTriplets(int[] nums) {
        int MOD = 1_000_000_007;
        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int num : nums) {
            rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);
        }
        
        Map<Integer, Integer> leftMap = new HashMap<>();
        long count = 0;
        
        for (int num : nums) {
            rightMap.put(num, rightMap.get(num) - 1);
            if (rightMap.get(num) == 0) {
                rightMap.remove(num);
            }
            
            // The problem likely asks for triplets (i, j, k) such that nums[i] = 2*nums[j] = nums[k]
            // or a similar relationship. Assuming the previous logic holds:
            int target = num * 2;
            if (leftMap.containsKey(target) && rightMap.containsKey(target)) {
                long leftCount = leftMap.get(target);
                long rightCount = rightMap.get(target);
                count = (count + leftCount * rightCount) % MOD;
            }
            
            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
        }
        
        return (int) count;
    }
}