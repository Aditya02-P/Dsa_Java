//public class SmallestDisWin {
//    static int isUnique(String str) {
//        boolean[] count = new boolean[256]; // To track characters seen in this window
//        int unique=0;
//        for (int k = 0; k < str.length(); k++) {
//            count[str.charAt(k)]=true;
//        }
//        for (int k = 0; k < 256; k++) {
//            if (count[k]) {
//                unique++;
//            }
//        }
//        return unique;
//    }
//    static int findSmallestDisWin(String str,int unique) {
//        int[] count = new int[256];
//        int smallest=str.length();
//        int start=0,end=0;
//        while(end<str.length()) {
//
//          if(count[str.charAt(end)]==0) {
//                unique--;
//           }

//            if(unique==0) {
//                while(count[str.charAt(start)]!=0) {
//                    count[str.charAt(start)]--;
//                }
//                start++;
//                unique++;
//            }
//
//
//            count[str.charAt(end)]++;
//
//            else{
//                count[str.charAt(end)]++;
//            }
//
//
//
//            end++;
//            smallest=Math.min(smallest,end-start+1);
//        }
//        return smallest;
//    }
//    public static void main(String[] args) {
//        String str = "AABBBCBBAC";
//        int unique = isUnique(str);
//        int disWin=findSmallestDisWin(str,unique);
//        System.out.println(disWin);
//    }
//}
public class SmallestDisWin {

    // (Your isUnique method is correct, keeping it as is)
    static int isUnique(String str) {
        boolean[] count = new boolean[256];
        int unique = 0;
        for (int k = 0; k < str.length(); k++) {
            count[str.charAt(k)] = true;
        }
        for (int k = 0; k < 256; k++) {
            if (count[k]) unique++;
        }
        return unique;
    }

    static int findSmallestDisWin(String str, int unique) {
        int[] count = new int[256];
        int smallest = Integer.MAX_VALUE;
        int start = 0, end = 0;

        // Loop runs as long as end is within bounds
        while (end < str.length()) {

            // --- EXPANSION PHASE ---
            if (count[str.charAt(end)] == 0) {
                unique--; // We found a new unique character we needed
            }
            count[str.charAt(end)]++;
            end++; // Move end forward

            // --- SHRINKING PHASE ---
            // We only try to shrink/record IF the window is currently valid (unique == 0)
            while (unique == 0) {

                // 1. CALCULATE SMALLEST HERE
                // The window is valid from 'start' to 'end-1' (since we did end++)
                int currentWindowSize = end - start;
                smallest = Math.min(smallest, currentWindowSize);

                // 2. REMOVE FROM START
                count[str.charAt(start)]--;

                // 3. CHECK IF WE BROKE THE WINDOW
                // If count becomes 0, it means we just removed the LAST instance of that char
                if (count[str.charAt(start)] == 0) {
                    unique++; // Window is no longer valid, we need this char back
                }

                start++; // Move start forward
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        String str = "AABBBCBBAC";
        int unique = isUnique(str);
        int disWin = findSmallestDisWin(str, unique);
        System.out.println(disWin);
    }
}
