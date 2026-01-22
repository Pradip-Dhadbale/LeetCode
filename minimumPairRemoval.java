import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);
        int ops = 0;
        
        while (true) {
            boolean sorted = true;
            int idx = 0, minSum = Integer.MAX_VALUE;
            
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) sorted = false;
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) { minSum = sum; idx = i; }
            }
            
            if (sorted) return ops;
            list.set(idx, minSum);
            list.remove(idx + 1);
            ops++;
        }
    }
}