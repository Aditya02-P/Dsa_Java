import java.util.Arrays;

public class StrPatMatchKMP {
    static int[] findLPS(String str) {
        int[] lps = new int[str.length()];
        int len=0,i=1;
        lps[0]=0;
        while(i<str.length()) {
            if(str.charAt(i)==str.charAt(len)) {
                len++;
                lps[i]=len;
                i++;
            }
            else {
                if(len!=0){
                    len=lps[len-1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    static int findMatch(String s, String p, int[] lps) {
        int i = 0, j = 0;

        while (i < s.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }

            if (j == p.length()) {
                return i - j;   // match found
            }
            else if (i < s.length() && s.charAt(i) != p.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1; // no match
    }


    public static void main(String[] args) {
        String str = "adfgabbbabbcdefg";
        String p = "abbbabb";
        int [] lps = findLPS(p);
        System.out.println(Arrays.toString(lps));
        int index=findMatch(str,p,lps);
        System.out.println("The Patterns Lies In Between: "+"str["+index+"] to str["+(index+p.length()-1)+"] is found");

    }
}
