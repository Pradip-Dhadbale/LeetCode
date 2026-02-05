class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int steps = nums[i];
            
            // Calculate target index.
            // In Java, % can return negative results (e.g., -1 % 5 = -1).
            // We add 'n' before taking modulo again to ensure a positive index.
            // Formula: ((i + steps) % n + n) % n
            int targetIndex = ((i + steps) % n + n) % n;
            
            result[i] = nums[targetIndex];
        }
        
        return result;
    }
}