import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
//        list.stream().filter(x->x%2==0).forEach(System.out::println);
//         List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
//
//// NO computation happens here. We are just building the pipeline.
//        Stream<String> pipeline = names.stream()
//                .filter(name -> {
//                    System.out.println("Filtering: " + name);
//                    return name.startsWith("C");
//                })
//                .map(name -> {
//                    System.out.println("Mapping: " + name);
//                    return name.toUpperCase();
//                });
//
//        System.out.println("Pipeline built. Starting execution...");
//
//// The terminal operation triggers the flow.
//        List<String> result = pipeline.toList();

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//        Optional<Integer> ans = list.stream().reduce(BinaryOperator.minBy(Comparator.comparingInt(a -> a)));
//        System.out.println(ans.get());
//            Map<Integer,Integer> l = list.stream().mapToInt(x-> x*x).collect(Collectors.toMap(x -> x, x -> x*2));
//        System.out.println(l);

        Optional<User> u = getUser();
        u.map(x->x.asd)
                .map(y->y.city)
                .filter(z->z.length()>8)
                .ifPresentOrElse(System.out::println,()-> System.out.println("ERROR"));


    
    }

    private static Optional<User> getUser(){
        Address a = new Address();
        a.city="kguda";
        User u = new User();
        u.asd=a;
        return Optional.ofNullable(u);
    }

}

class User{
    public Address asd;
}
class Address{
    public String city;
}
