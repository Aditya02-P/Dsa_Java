import java.util.Arrays;

public class SWlongsubstr {
    static int findLSB(String str) {
        int len = str.length();
        if (len <= 1) return len;

        int maxRes = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                // Check if characters from i to j are all unique
                if (isUnique(str, i, j)) {
                    maxRes = Math.max(maxRes, j - i + 1);
                } else {
                    break; // Found a duplicate, no need to extend this window further
                }
            }
        }
        return maxRes;
    }

    // Helper to check if window is actually unique
    static boolean isUnique(String str, int start, int end) {
        boolean[] visited = new boolean[256]; // To track characters seen in this window
        for (int k = start; k <= end; k++) {
            if (visited[str.charAt(k)]) return false;
            visited[str.charAt(k)] = true;
        }
        return true;
    }

    static int findLongestSubstr(String str) {
        boolean[] visited = new boolean[256];
        int n = str.length();
        int maxRes = 0;
        int start = 0;
        int end = 0;

        while (end < n) {
            char currentChar = str.charAt(end);

            // If we've seen this char, shrink the window from the left
            while (visited[currentChar]) {
                visited[str.charAt(start)] = false;
                start++;
            }

            // Add the current char and expand the window
            visited[currentChar] = true;

            // Update the maximum length found so far
            maxRes = Math.max(maxRes, end - start + 1);
            end++;
        }
        return maxRes;
    }


    public static void main(String[] args) {
        String str = "abcadaeafag";
        int ans = findLSB(str);
        System.out.println(ans);
        System.out.println(findLongestSubstr(str));
    }
}
