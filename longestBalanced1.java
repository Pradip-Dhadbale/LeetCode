class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int maxFreq = 0;
            int distinctCount = 0;
            
            for (int j = i; j < n; j++) {
                int charIdx = s.charAt(j) - 'a';
                
                if (freq[charIdx] == 0) {
                    distinctCount++;
                }
                
                freq[charIdx]++;
                maxFreq = Math.max(maxFreq, freq[charIdx]);
                
                // If max frequency * distinct count equals total length, 
                // it means all present characters have the same frequency.
                int currentLen = j - i + 1;
                if (maxFreq * distinctCount == currentLen) {
                    ans = Math.max(ans, currentLen);
                }
            }
        }
        
        return ans;
    }
}