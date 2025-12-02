import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }

        long ans = 0;
        long prevSegments = 0;
        int MOD = 1_000_000_007;

        for (int count : map.values()) {
            if (count < 2) continue;

            long currSegments = (long) count * (count - 1) / 2;

            ans = (ans + currSegments * prevSegments) % MOD;
            prevSegments = (prevSegments + currSegments) % MOD;
        }

        return (int) ans;
    }
}