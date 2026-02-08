public class Stringmatchkmp {
    static void matchBrute1(String str, String pat) {
        int n = str.length();
        int m = pat.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && str.charAt(i + j) == pat.charAt(j)) {
                j++;
            }

            if (j == m) {
                System.out.println(i); // match found at index i
                return;
            }
        }

        System.out.println("Pattern not found");
    }
    static void matchBrute2(String str, String pat) {
        int i = 0, j = 0, start = 0;

        while (i < str.length()) {
            if (str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                if (j == pat.length()) {
                    System.out.println(start);
                    return;
                }
            } else {
                start++;
                i = start;
                j = 0;
            }
        }

        System.out.println("Pattern not found");
    }

    public static void main(String[] args) {

        String str="abxdfcdbdefg";
        String pat="def";
        matchBrute1(str,pat);
    }
}
