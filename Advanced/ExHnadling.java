import java.text.DecimalFormat;
import java.util.Scanner;

public class ExHnadling {
    public static void main(String[] args) {

//        System.out.print("Enter a number to find inverse:");
//        int num = new Scanner(System.in).nextInt();
        System.out.println("step1");
//        try {
//            int a=1/num;
//            System.out.println("Inverse of a="+num+"is: "+new DecimalFormat("#.00").format(a));
//        }catch (Exception e){
//            System.out.println("ERROR"+ e);
//        }
//        System.out.println(a());
        a();
        System.out.println("step2");
//        System.out.println(a());

    }
    //the below prints the stack trace of the stack and how the stack unwind itself to reach the default handler
    public static int a(){
        return  b();
    }
    public static int b(){
        return c();
    }
    public static int c(){
        try {
            return 1/0;
        }catch (ArithmeticException e){
            System.out.println("ArithmeticException");
            e.printStackTrace(System.out);
        }
        System.out.println("stepC");
        return 0;

    }
}
