class Solution {
    public boolean isValid(String s) {
       
        int lenBefore = -1; 
        
        while (lenBefore != s.length()) {
            lenBefore = s.length();
            
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        
        return s.isEmpty();
    }
}