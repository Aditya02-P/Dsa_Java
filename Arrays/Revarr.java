import java.util.Arrays;

public class Revarr {
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7,8};
        int left=0,right=arr.length-1;
        int temp=0;
        while (left<right) {
            temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
