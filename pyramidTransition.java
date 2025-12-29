import java.util.*;

class Solution {
    Map<String, List<Character>> map = new HashMap<>();
    Map<String, Boolean> memo = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return solve(bottom, "");
    }

    private boolean solve(String row, String next) {
        if (row.length() == 1) return true;
        if (next.length() == row.length() - 1) {
            if (memo.containsKey(next)) return memo.get(next);
            boolean res = solve(next, "");
            memo.put(next, res);
            return res;
        }

        int i = next.length();
        String key = row.substring(i, i + 2);
        
        if (map.containsKey(key)) {
            for (char c : map.get(key)) {
                if (solve(row, next + c)) return true;
            }
        }
        
        return false;
    }
}