class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        long currentDpSum = 0;
        int left = 0;
        
        for (int i = 0; i < n; i++) {
            currentDpSum = (currentDpSum + dp[i]) % MOD;
            
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            
            while (map.lastKey() - map.firstKey() > k) {
                currentDpSum = (currentDpSum - dp[left] + MOD) % MOD;
                
                int leftVal = nums[left];
                if (map.get(leftVal) == 1) {
                    map.remove(leftVal);
                } else {
                    map.put(leftVal, map.get(leftVal) - 1);
                }
                left++;
            }
            
            dp[i + 1] = (int) currentDpSum;
        }
        
        return dp[n];
    }
}