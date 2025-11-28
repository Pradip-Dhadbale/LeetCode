import java.util.ArrayList;
import java.util.List;

class Solution {
    int count = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1, adj, values, k);

        return count;
    }

    private long dfs(int currentNode, int parent, List<List<Integer>> adj, int[] values, int k) {
        long currentSum = values[currentNode];

        for (int neighbor : adj.get(currentNode)) {
            if (neighbor != parent) {
                currentSum += dfs(neighbor, currentNode, adj, values, k);
            }
        }

        if (currentSum % k == 0) {
            count++;
            return 0;
        }

        return currentSum;
    }
}