import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        // Use LinkedList as a Queue
        LinkedList<String> queue = new LinkedList<>();
        if (digits.isEmpty()) return queue;
        
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        queue.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            String letters = mapping[num];
            
            // Process only strings created in the previous step
            while (queue.peek().length() == i) {
                String current = queue.remove();
                
                for (char c : letters.toCharArray()) {
                    queue.add(current + c);
                }
            }
        }
        
        return queue;
    }
}