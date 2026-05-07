import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        list.stream().filter(x->x%2==0).forEach(System.out::println);
         List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// NO computation happens here. We are just building the pipeline.
        Stream<String> pipeline = names.stream()
                .filter(name -> {
                    System.out.println("Filtering: " + name);
                    return name.startsWith("C");
                })
                .map(name -> {
                    System.out.println("Mapping: " + name);
                    return name.toUpperCase();
                });

        System.out.println("Pipeline built. Starting execution...");

// The terminal operation triggers the flow.
        List<String> result = pipeline.toList();
    
    }
}
