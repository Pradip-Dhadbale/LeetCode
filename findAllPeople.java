import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));
        
        boolean[] hasSecret = new boolean[n];
        hasSecret[0] = true;
        hasSecret[firstPerson] = true;
        
        int m = meetings.length;
        int i = 0;
        
        while (i < m) {
            int time = meetings[i][2];
            int j = i;
            
            while (j < m && meetings[j][2] == time) {
                j++;
            }
            
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> activeParticipants = new HashSet<>();
            
            for (int k = i; k < j; k++) {
                int u = meetings[k][0];
                int v = meetings[k][1];
                
                graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
                graph.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
                activeParticipants.add(u);
                activeParticipants.add(v);
            }
            
            Queue<Integer> queue = new ArrayDeque<>();
            for (int person : activeParticipants) {
                if (hasSecret[person]) {
                    queue.offer(person);
                }
            }
            
            while (!queue.isEmpty()) {
                int u = queue.poll();
                if (!graph.containsKey(u)) continue;
                
                for (int v : graph.get(u)) {
                    if (!hasSecret[v]) {
                        hasSecret[v] = true;
                        queue.offer(v);
                    }
                }
            }
            
            i = j;
        }
        
        List<Integer> result = new ArrayList<>();
        for (int k = 0; k < n; k++) {
            if (hasSecret[k]) {
                result.add(k);
            }
        }
        
        return result;
    }
}