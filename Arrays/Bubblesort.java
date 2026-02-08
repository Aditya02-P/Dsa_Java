import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6,7,8,9};
        boolean swap=false;
        int it=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    System.out.println(Arrays.toString(arr));
                    swap=true;
                }
                if(!swap){
                    break;
                }
                it++;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Iteration Count: "+it);
    }
}
