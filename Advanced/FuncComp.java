import java.util.function.*;
public class FuncComp {
    public static void main(String[] args) {
       BiFunction<Integer, Integer,Integer> f_x = (x,y) -> x^2 +2*x*y+y^2 ;
       Function<Integer, Integer> g_x = x -> x *3 ;
//        System.out.println(g_x.apply(f_x.apply(1,2)));
        int ans = f_x.andThen(g_x).apply(1,2);
        System.out.println(ans);
    }
}
