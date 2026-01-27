import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {
        // Adjacency list to store the graph
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, k -> new ArrayList<>());
        
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            // Original edge: u -> v with cost w
            graph[u].add(new int[]{v, w});
            
            // Reversed edge option: v -> u becomes u -> v with cost 2 * w
            // This represents using the switch at node v to reverse the incoming edge u->v? 
            // Wait, logic check: "At node u... reverse incoming edge v->u".
            // So if input is v->u (cost w), we can go u->v (cost 2w).
            // Input gives u->v (cost w). So at v, we can reverse u->v to go v->u (cost 2w).
            // My previous Python comment was slightly ambiguous, but the code logic is symmetric.
            // u->v in input means we can travel u->v (cost w) OR v->u (cost 2w via switch at v).
            graph[v].add(new int[]{u, 2 * w});
        }
        
        // PriorityQueue stores {node, cost}, sorted by cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{0, 0});
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            
            if (d > dist[u]) continue;
            if (u == n - 1) return d;
            
            for (int[] next : graph[u]) {
                int v = next[0];
                int weight = next[1];
                
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        
        return -1;
    }
}