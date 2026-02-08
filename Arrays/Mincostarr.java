import java.util.ArrayList;
import java.util.Arrays;

public class Mincostarr {

    public static void findTwoMinIndex(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array must have at least two elements");
            return;
        }

        int min1Idx = -1;
        int min2Idx = -1;

        for (int i = 1; i < arr.length; i++) {
            if (min1Idx == -1 || arr[i] < arr[min1Idx]) {
                min2Idx = min1Idx;
                min1Idx = i;
            } else if (
                    min2Idx == -1 ||
                            (arr[i] > arr[min1Idx] && arr[i] < arr[min2Idx])
            ) {
                min2Idx = i;
            }
        }

        int fi = Math.min(min1Idx, min2Idx);
        int li = Math.max(min1Idx, min2Idx);
        int[][] ans={{arr[0]}, Arrays.copyOfRange(arr,fi ,li), Arrays.copyOfRange(arr,li ,arr.length )};
        System.out.println(Arrays.deepToString(ans));

        }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        findTwoMinIndex(arr);
    }
}
