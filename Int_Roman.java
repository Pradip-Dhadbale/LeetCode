class Solution {
    public String intToRoman(int num) {
        
        // 1. Create the look-up arrays, largest to smallest.
        int[] values = {
            1000, 900, 500, 400, 100, 
            90, 50, 40, 10, 9, 5, 4, 1
        };
        
        String[] symbols = {
            "M", "CM", "D", "CD", "C", 
            "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        
        // 2. Build the string
        StringBuilder romanResult = new StringBuilder();
        
        // Loop through all the possible values
        for (int i = 0; i < values.length; i++) {
            
            // 3. Greedily subtract values
            // Keep subtracting the same value (e.g., 1000)
            // until it's no longer possible.
            while (num >= values[i]) {
                romanResult.append(symbols[i]);
                num = num - values[i];
            }
        }
        
        return romanResult.toString();
    }
}