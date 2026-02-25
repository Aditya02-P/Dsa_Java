import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationArr {

    public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }



    private static void backtrack(int[] nums, boolean[] used, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {

        // base case
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // copy
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // choose
            used[i] = true;
            current.add(nums[i]);

            // explore
            backtrack(nums, used, current, result);

            // un-choose (backtrack)
            current.removeLast();
            used[i] = false;
        }
    }
    static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);                  // step 1
        boolean[] used = new boolean[nums.length];
        backtrack2(nums, used, new ArrayList<>(), result);
        return result;
    }

    static void backtrack2(int[] nums, boolean[] used,
                          List<Integer> temp, List<List<Integer>> result) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // already used in current permutation
            if (used[i]) continue;

            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            temp.add(nums[i]);

            backtrack2(nums, used, temp, result);

            // backtrack
            used[i] = false;
            temp.removeLast();
        }
    }

    // test
    public static void main(String[] args) {
        int[] arr = {1,1, 2};
        ArrayList<ArrayList<Integer>> permutations = permute(arr);
        System.out.println(permutations);
        List<List<Integer>> unique = permuteUnique(arr);
        System.out.println(unique);
    }
}