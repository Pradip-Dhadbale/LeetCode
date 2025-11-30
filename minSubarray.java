import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        int target = (int)(totalSum % p);
        if (target == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        long currentSum = 0;
        int minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int currentMod = (int)(currentSum % p);
            int needed = (currentMod - target + p) % p;

            if (map.containsKey(needed)) {
                minLen = Math.min(minLen, i - map.get(needed));
            }
            
            map.put(currentMod, i);
        }

        return minLen == nums.length ? -1 : minLen;
    }
}