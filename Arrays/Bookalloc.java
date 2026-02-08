public class Bookalloc {

    public static void main(String[] args) {
        int[] pages = { 12, 34, 67, 90 };
        int students = 2;
        int min = allocateBook(pages, students);
        System.out.println("The Min Pages: " + min);
    }

    static int allocateBook(int[] arr, int students) {
        int sum = 0;
        int max = 0;

        for (int page : arr) {
            sum += page;
            max = Math.max(max, page);
        }

        int start = max, end = sum;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (checkAllocation(arr, students, mid)) {
                ans = mid; 
                end = mid - 1; 
            } else {
                start = mid + 1; 
            }
        }
        return ans;
    }

    static boolean checkAllocation(int[] arr, int students, int maxPages) {
        int studentCount = 1;
        int currentSum = 0;

        for (int pages : arr) {
            if (currentSum + pages <= maxPages) {
                currentSum += pages;
            } else {
                studentCount++;
                currentSum = pages;

                if (studentCount > students) {
                    return false; 
                }
            }
        }
        return true; 
    }
}
