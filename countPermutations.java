class Solution {
    public int countPermutations(int[] complexity) {
        long MOD = 1_000_000_007;
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }
        
        long ans = 1;
        for (int i = 1; i < complexity.length; i++) {
            ans = (ans * i) % MOD;
        }
        return (int) ans;
    }
}