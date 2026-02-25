import java.util.ArrayList;
import java.util.Arrays;

public class WaysumN {
    static void findTargetSumWays(int[] arr, int targetSum, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp) {
        if(targetSum <0 ){
            return;
        }
        if (targetSum==0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int j : arr) {
            temp.add(j);
            findTargetSumWays(arr, targetSum - j, list, temp);
            temp.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int target = 6;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        findTargetSumWays(arr,target,list,new ArrayList<>());
        System.out.println(Arrays.toString(list.toArray()));


    }
}
