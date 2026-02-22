import java.util.ArrayList;

public class Subsequence {

    static void subSeq(int[] arr, int index, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp) {

        if (index == arr.length) {
            list.add(new ArrayList<>(temp)); // copy
            return;
        }

        // don't select
        subSeq(arr, index + 1, list, temp);

        // select
        temp.add(arr[index]);
        subSeq(arr, index + 1, list, temp);

        // backtrack
        temp.removeLast();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        subSeq(arr, 0, list, new ArrayList<>());
        System.out.println(list);
    }
}