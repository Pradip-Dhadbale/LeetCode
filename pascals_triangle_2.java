import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        // Start with the first 1
        row.add(1);
        
        // Build up to the requested row index
        for (int i = 1; i <= rowIndex; i++) {
            
            // 1. Add a 1 at the end for the new row
            // (e.g., [1, 1] becomes [1, 1, 1])
            row.add(1);
            
            // 2. Update the middle elements BACKWARDS
            // We go from right to left so we don't overwrite 
            // values we still need to read.
            for (int j = i - 1; j > 0; j--) {
                int sum = row.get(j) + row.get(j - 1);
                row.set(j, sum);
            }
        }
        
        return row;
    }
}