import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }
        
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });
        
        int[] count = new int[n];
        
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }
            
            if (!available.isEmpty()) {
                int room = available.poll();
                busy.offer(new long[]{end, room});
                count[room]++;
            } else {
                long[] current = busy.poll();
                long finishTime = current[0];
                int room = (int) current[1];
                busy.offer(new long[]{finishTime + end - start, room});
                count[room]++;
            }
        }
        
        int maxCalls = 0;
        int resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxCalls) {
                maxCalls = count[i];
                resultRoom = i;
            }
        }
        
        return resultRoom;
    }
}