import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;

        // Case 1: Single char runs
        int currentRun = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                currentRun++;
            } else {
                currentRun = 1;
            }
            ans = Math.max(ans, currentRun);
        }

        // Case 2: Pairs (a,b), (b,c), (a,c)
        ans = Math.max(ans, solveTwo(s, 'a', 'b', 'c'));
        ans = Math.max(ans, solveTwo(s, 'b', 'c', 'a'));
        ans = Math.max(ans, solveTwo(s, 'a', 'c', 'b'));

        // Case 3: All three (a,b,c)
        // Key is string "diff1,diff2" or a custom Hash object
        Map<String, Integer> map = new HashMap<>();
        map.put("0,0", -1);
        int ca = 0, cb = 0, cc = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') ca++;
            else if (c == 'b') cb++;
            else if (c == 'c') cc++;

            int diff1 = ca - cb;
            int diff2 = cb - cc;
            String key = diff1 + "," + diff2;

            if (map.containsKey(key)) {
                ans = Math.max(ans, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }

        return ans;
    }

    private int solveTwo(String s, char x, char y, char forbidden) {
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int bal = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == forbidden) {
                map.clear();
                map.put(0, i);
                bal = 0;
            } else {
                if (c == x) bal++;
                else if (c == y) bal--;
                
                if (map.containsKey(bal)) {
                    maxLen = Math.max(maxLen, i - map.get(bal));
                } else {
                    map.put(bal, i);
                }
            }
        }
        return maxLen;
    }
}