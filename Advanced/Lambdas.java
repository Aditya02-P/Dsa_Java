import java.util.ArrayList;
import java.util.function.*;
public class Lambdas {
    public static void main(String[] args) {
//        System.out.println(new Sum().calculate());
//        Calculate c= new Mul();
//        System.out.println(calc(2,3,(a,b)->a+b));
//        Function<Integer, Integer> f = x -> x*x;
//        System.out.println(f.apply(2));
//        Consumer<String> c = x-> System.out.println(x+" this is it");
//        c.accept("hello");
//        Supplier<String> s = () -> "hello";
//        s.get();
//        Predicate<Integer> p = x -> x%2==0;
//        System.out.println(p.test(4));
//        Consumer<Integer> cc = System.out::println;
//        cc.accept(1);
        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test(""));

    }



    public static int calc(int a, int b,Calculate c) {// the compiler know the lambda received in the 3rd param is overriding the abs func of the Calculate interface
        return c.calculate(a,b);
    }

}

interface Calculate{
    int calculate(int a, int b);
}
//class Sum implements Calculate{
//    @Override
//    public int calculate(int a, int b) {
//        return a+b;
//    }
//}
//
//class Mul implements Calculate{
//    @Override
//    public int calculate(int a, int b) {
//        return a*b;
//    }
//}