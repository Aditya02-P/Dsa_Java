import java.util.ArrayList;
import java.util.Arrays;

public class Targets {
    static void targetSum(int[]arr, int index, int sum, int target, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp) {
        if(index==arr.length) {
            if(sum==target) {
                list.add(new ArrayList<Integer>(temp));
                System.out.println("Target found");
            }
            return;
        }
        targetSum(arr,index+1,sum,target,list,temp);
        temp.add(arr[index]);
        targetSum(arr,index+1,sum+arr[index],target,list,temp);
        temp.removeLast();

    }

    static boolean findTargetSum(int[]arr,int index, int target) {
        if(target==0) {
            System.out.println("Target found");
            return true;
        }
        if(index==arr.length || target<0) {
            return false;
        }
        return findTargetSum(arr,index+1,target) || findTargetSum(arr,index+1,target-arr[index]);//The || is used to stop
        //calling the deeper calls if a sum is found at a top level , this saves stack frames , memory and cpu cycles

    }

    static int findTargetSumOcc(int[]arr,int index, int target) {
        if(target==0) {
            System.out.println("Target found");
            return 1;
        }
        if(index==arr.length || target<0) {
            return 0;
        }
        return findTargetSumOcc(arr,index+1,target) + findTargetSumOcc(arr,index+1,target-arr[index]);

    }

    public static void main(String[] args) {
        int[]arr={0,1,2,3,4,5,6,7};
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        targetSum(arr,0,0,10,list,new ArrayList<>());
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(findTargetSum(arr,0,10));
        System.out.println(findTargetSumOcc(arr,0,10));

    }
}
