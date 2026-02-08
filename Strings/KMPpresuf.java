public class KMPpresuf {
    public static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int length = 0; // Length of the previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // lps[0] is always 0

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                // This is the tricky fallback logic
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String txt = "ABCABDABCABDABDAB";
        int[] lps = computeLPSArray(txt);

        System.out.println("LPS Array:");
        for (int n : lps) {
            System.out.print(n + " ");
        }
    }
}