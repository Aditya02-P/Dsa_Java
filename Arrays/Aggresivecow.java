import java.util.*;
public class Aggresivecow {
    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int cows = 3;

        System.out.println("Maximum minimum distance: " + solve(stalls, cows));
    }

    public static int solve(int[] stalls, int k) {
        // Step 1: Sort stalls to place cows linearly
        Arrays.sort(stalls);

        int n = stalls.length;
        int low = 1; // Minimum possible distance
        int high = stalls[n - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                result = mid; // This distance is possible, try for a larger one
                low = mid + 1;
            } else {
                high = mid - 1; // Distance too large, shrink it
            }
        }
        return result;
    }

    // Greedy function to check if we can place 'k' cows with at least 'dist' apart
    private static boolean canPlaceCows(int[] stalls, int k, int dist) {
        int count = 1; // Place the first cow at the first stall
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= dist) {
                count++;
                lastPosition = stalls[i];
            }
            if (count >= k) return true;
        }
        return false;
    }
}
