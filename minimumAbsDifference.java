import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        
        // 1. Find the minimum absolute difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i+1] - arr[i]);
        }
        
        // 2. Collect all pairs with that difference
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i+1] - arr[i] == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        
        return result;
    }
}