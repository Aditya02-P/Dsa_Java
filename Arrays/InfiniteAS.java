public class InfiniteAS {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15, 18, 21, 23, 29 };
        int ans = findIndexInf(arr, 18);
        System.out.println(ans);
    }

    static int findIndexInf(int[] arr, int target) {
        int start = 0, end = 1;
        while (target > arr[end]) {
            int newStart = end+1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(arr, start, end, target);
    }

    static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
