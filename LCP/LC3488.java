import java.util.*;

public class LC3488 {
    public int findClosest(int[] nums, int startIndex, int target, int len) {
        int distF = 1;
        int distB = 1;
        int index = startIndex + 1;

        boolean isP = false;

        do {
            if (nums[index] == target) {
                isP = true;
                break;
            }
            distF++;
            index = (index + 1) % len;
        } while (index != startIndex);

        if (!isP) {
            return -1;
        }

        index = (startIndex - 1 + len) % len;
        do {
            if (nums[index] == target) {
                break;
            }
            distB++;
            index = (index - 1 + len) % len;
        } while (index != startIndex);

        return Math.min(distF, distB);
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> list = new ArrayList<>();
        int len = queries.length;

        for (int elem : queries) {
            int ans = findClosest(nums, elem, nums[elem], len);
            list.add(ans);
        }

        return list;
    }

    public static void main(String[] args) {
        LC3488 sol = new LC3488();

        // Example test case
        int[] nums = {1, 2, 3, 2, 1, 2, 3};
        int[] queries = {0, 1, 2, 3, 4};

        List<Integer> result = sol.solveQueries(nums, queries);

        System.out.println("Result:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}