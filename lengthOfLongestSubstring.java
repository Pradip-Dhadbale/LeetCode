class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[128];
        for (int i = 0; i < 128; i++) charIndex[i] = -1;
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (charIndex[c] >= left) {
                left = charIndex[c] + 1;
            }
            charIndex[c] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}