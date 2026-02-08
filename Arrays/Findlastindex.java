import java.util.Arrays;

public class Findlastindex {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10, 11, 11, 11, 11, 11, 11, 11 };
        System.out.println(arr.length);
        int[] index = findIndex(arr, 11);
        System.out.println("[First Index,Last Index]: " + Arrays.toString(index));
    }

    static int[] findIndex(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans1 = -1, ans2 = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                ans2 = mid;
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        }
        start=0;
        end=arr.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                ans1 = mid;
                end = mid - 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        }
        return new int[] {ans1,ans2};

    }
}
