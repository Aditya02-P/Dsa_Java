import java.util.Arrays;

public class Insertionsort {
    public static void main(String[] args) {
        int[]arr={9,8,7,6,5,4,3,2,1};
        for(int i=1;i< arr.length;i++){
            System.out.println("Round: "+i);
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println("Final:"+Arrays.toString(arr));
    }
}
