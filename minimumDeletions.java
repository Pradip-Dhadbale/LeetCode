class Solution {
    public int minimumDeletions(String s) {
        int countB = 0;
        int deletions = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                countB++;
            } else if (countB > 0) {
                // Found 'a' with preceding 'b's (violation).
                // Increment deletions and 'use up' one 'b' to resolve the pair.
                deletions++;
                countB--;
            }
        }
        
        return deletions;
    }
}