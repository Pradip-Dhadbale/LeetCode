import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        // Sort events: by time (asc), then OFFLINE before MESSAGE
        Collections.sort(events, (a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB) return Integer.compare(timeA, timeB);
            
            // If times are equal, OFFLINE (-1) should be processed before MESSAGE (1)
            String typeA = a.get(0);
            String typeB = b.get(0);
            if (typeA.equals(typeB)) return 0;
            return typeA.equals("OFFLINE") ? -1 : 1;
        });

        int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];

        for (List<String> event : events) {
            String type = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));
            String data = event.get(2);

            if (type.equals("OFFLINE")) {
                int userId = parseId(data);
                offlineUntil[userId] = timestamp + 60;
            } else {
                if (data.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }
                } else if (data.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        // User is online if current time >= offlineUntil time
                        if (timestamp >= offlineUntil[i]) {
                            mentions[i]++;
                        }
                    }
                } else {
                    String[] ids = data.split(" ");
                    for (String idStr : ids) {
                        int userId = parseId(idStr);
                        mentions[userId]++;
                    }
                }
            }
        }
        return mentions;
    }

    // Helper to safely parse "id123" or just "123"
    private int parseId(String s) {
        if (s.startsWith("id")) {
            return Integer.parseInt(s.substring(2));
        }
        return Integer.parseInt(s);
    }
}
