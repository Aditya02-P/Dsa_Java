public class Secmax {
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7,8};
        int max=arr[0],smax=0;
        for (int elem : arr) {
            if(elem>max){
                smax=max;
                max=elem;
            }
        }
        System.out.println("The Max Element Is:"+max+"\nSecond Max Element Is:"+smax);
    }
}
