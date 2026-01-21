import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int val = nums.get(i);
            
            if (val % 2 == 0) {
                result[i] = -1;
            } else {
                // val + 1 turns trailing 1s into 0s (e.g., ...0111 -> ...1000)
                // & -(val + 1) isolates that new 1 bit
                // >> 1 moves us back to the most significant bit of the original trailing 1s
                int bitToRemove = ((val + 1) & -(val + 1)) >> 1;
                result[i] = val - bitToRemove;
            }
        }
        
        return result;
    }
}