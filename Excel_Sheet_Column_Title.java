class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            // 1. Crucial step: Adjust for 1-based indexing
            columnNumber--; 
            
            // 2. Modulus to get the "digit" (0-25)
            int remainder = columnNumber % 26; 
            
            // 3. Convert digit (0=A, 1=B, ..., 25=Z)
            char letter = (char)('A' + remainder); 
            
            // 4. Prepend the letter
            result.insert(0, letter); 
            
            // 5. Update number for the next position
            columnNumber /= 26; 
        }
        
        return result.toString();
    }
}