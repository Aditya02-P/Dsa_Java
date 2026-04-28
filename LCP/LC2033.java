import java.util.Arrays;

class LC2033 {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int totalElements = m * n;
        int[] arr = new int[totalElements];
        int k = 0;

        // 1. Flatten the 2D grid into a 1D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[k++] = grid[i][j];
            }
        }

        Arrays.sort(arr);

        int median = arr[totalElements / 2];
        int operations = 0;

        for (int val : arr) {
            int diff = Math.abs(val - median);
            if (diff % x != 0) {
                return -1;
            }

            operations += diff / x;
        }

        return operations;
    }
}