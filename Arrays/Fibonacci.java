public class Fibonacci {
    public static void main(String[] args) {
        int fn = 0, sn = 1;
        int num = 10;
        int temp=0;
        System.out.print("First Num:" + fn +","+ sn);
        for(int i=0;i<num;i++){
            temp=fn+sn;
            System.out.print(","+temp);
            fn=sn;
            sn=temp;
        }
    }
}