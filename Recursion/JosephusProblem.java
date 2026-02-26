import java.util.Scanner;

public class JosephusProblem {

    // n = total people (alive), k = step size (eleP)
    static int josephusSimulation(int k, int n) {
        int[] arr = new int[n]; // 0 means alive, 1 means eliminated
        int countAlive = n;
        int index = 0;
        int stepCount = 0;

        // Keep looping until only 1 person is left
        while (countAlive > 1) {
            if (arr[index] == 0) { // Only count if the person is alive
                stepCount++;

                if (stepCount == k) { // We found the k-th alive person!
                    arr[index] = 1;   // Eliminate them
                    countAlive--;     // Decrease total alive count
                    stepCount = 0;    // Reset step counter for the next round
                }
            }
            // Move to the next person, wrapping around the circle
            index = (index + 1) % n;
        }

        // Search the array for the single remaining 0
        int win = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                win = i + 1; // +1 to convert from 0-based index to 1-based position
                break;
            }
        }
        return win;
    }

    static int winner(int k, int n) {
        if(n==1){
            return 0;
        }
        return (winner(k, n-1)+k)% n ;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the step size (k): ");
//        int k = sc.nextInt();
//        System.out.println("Enter the total number of people (n): ");
//        int n = sc.nextInt();
//
//        int win = josephusSimulation(k, n);
//        System.out.println("The Winning Position Is: " + win);
        int k=3,n=5;
        System.out.println("The Winning Position Is: " + winner(k, n));
    }
}