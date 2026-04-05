import java.util.ArrayDeque;
import java.util.Queue;

public class PrintKwinElemQ {

    public static void printKwinelem(int[] arr, int k) {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
        }
        printQueue(q);

        for (int j = k; j < arr.length; j++) {
            q.poll();           // remove front
            q.add(arr[j]);      // add next element
            printQueue(q);      // print current window
        }
    }

    public static void printQueue(Queue<Integer> q) {
        for (int e : q) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static String printNRC(String s) {
        // Edge case handling
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        int[] freq = new int[26];
        Queue<Character> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            q.add(c);

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            if (q.isEmpty()) {
                sb.append('$');
            } else {
                sb.append(q.peek());
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6};
//        printKwinelem(arr, 3);
        System.out.println(printNRC("abcacdbd"));
    }
}