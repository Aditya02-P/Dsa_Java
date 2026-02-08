public class Kthmissing {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 2;

        System.out.println("Array: {2, 3, 4, 7, 11}");
        System.out.println("k = " + k);
        System.out.println("--------------------------------");

        int result = findKthPositive(arr, k);

        System.out.println("--------------------------------");
        System.out.println("Final Answer:");
        System.out.println("The " + k + "nd missing positive number is: " + result);
    }

    static int findKthPositive(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        int step = 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int miss = arr[mid] - (mid + 1);

            System.out.println("Step " + step++);
            System.out.println("start = " + start + ", end = " + end);
            System.out.println("mid = " + mid);
            System.out.println("arr[mid] = " + arr[mid]);
            System.out.println("Missing numbers till index " + mid + " = "
                    + arr[mid] + " - (" + mid + " + 1) = " + miss);

            if (miss >= k) {
                System.out.println("miss >= k (" + miss + " >= " + k + ")");
                System.out.println("Move left → end = mid - 1");
                end = mid - 1;
            } else {
                System.out.println("miss < k (" + miss + " < " + k + ")");
                System.out.println("Move right → start = mid + 1");
                start = mid + 1;
            }

            System.out.println("--------------------------------");
        }

        System.out.println("Binary search finished");
        System.out.println("start = " + start);
        System.out.println("Answer = start + k = " + start + " + " + k);

        return start + k;
    }
}
