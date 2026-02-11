public class Fibonacci {
    //IT is a series in which the fn=0,sn=1, the next number is determined by adding the previous 2 numbers
    static int fib(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}
