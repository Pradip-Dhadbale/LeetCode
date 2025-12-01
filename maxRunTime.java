import java.util.Arrays;

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        // 1. Calculate the total sum of all batteries
        long sum = 0;
        for (int b : batteries) {
            sum += b;
        }

        // 2. Sort the batteries to handle the largest ones first
        Arrays.sort(batteries);

        // 3. Loop from the largest battery downwards
        // 'i' is the index of the battery we are checking
        for (int i = batteries.length - 1; i >= 0; i--) {
            
            // Calculate the theoretical average time for the remaining 'n' computers
            long theoreticalTime = sum / n;

            // Check if the current largest battery is "too big"
            if (batteries[i] > theoreticalTime) {
                // This battery can power one computer entirely on its own.
                // So, we "assign" it to one computer and remove both from the calculation.
                sum -= batteries[i];
                n--; 
            } else {
                // If the largest remaining battery is <= average, 
                // it means all batteries can perfectly share the load.
                // We found our answer.
                return theoreticalTime;
            }
        }
        
        return 0; // Should not reach here
    }
}