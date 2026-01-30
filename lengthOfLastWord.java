class Solution {
    public int lengthOfLastWord(String s) {
        // Remove trailing spaces so we are guaranteed to end with a word
        s = s.trim();
        
        // Find the last space
        int lastSpaceIndex = s.lastIndexOf(' ');
        
        // The length is the total length minus the characters up to the last space
        return s.length() - lastSpaceIndex - 1;
    }
}