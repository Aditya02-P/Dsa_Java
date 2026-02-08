public class Findceli {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
        System.out.println(findCeil(arr, 7));
    }

    static int findCeil(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                ans = arr[mid];
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        }

        return ans;
    }
}