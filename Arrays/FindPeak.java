// public class FindPeak {
//     public static void main(String[] args) {
//         int[] arr = { 1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2 };
//         int peak = findPeakIndex(arr);
//         System.out.println("Peak index is :" + peak);
//     }

//     static int findPeakIndex(int[] arr) {
//         int start = 0, end = arr.length - 1;
//         while (start <= end) {
//             int mid = start + (end - start) / 2;
//             if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
//                 start = mid + 1;
//             } else if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
//                 end = mid - 1;
//             } else if (arr[mid] >= arr[mid + 1] && arr[mid] >= arr[mid - 1]) {
//                 return mid;
//             }
//         }
//         return -1;
//     }
// }
public class FindPeak {
    public static void main(String[] args) {
        // Even edge cases like these will now work without crashing
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2 };
        // int[]arr={1,5,2};
        int peak = findPeakIndex(arr);
        System.out.println("Peak index is: " + peak);
    }

    static int findPeakIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        // Notice: check 'start < end', NOT 'start <= end'
        // We want the loop to break when they meet at the single peak element.
        while (start < end) {
            int mid = start + (end - start) / 2;
            System.out.println("Checking range [" + start + ", " + end + "]. Mid is index " + mid + " value " + arr[mid]);
            if (arr[mid] < arr[mid + 1]) {
                // We are in the ascending part of the mountain.
                // The peak MUST be to the right, so we can skip 'mid' itself.
                start = mid + 1;
            } else {
                // We are in the descending part of the mountain OR at the peak.
                // We cannot skip 'mid' because it might be the peak.
                // So we set end = mid, not mid - 1.
                end = mid;
            }
        }
        // When start == end, we found the peak
        return start; 
    }
}