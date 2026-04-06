import java.util.*;

public class Basics7 {
    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet<>();
        set.add(50);
        set.add(60);
        set.add(40);
        set.add(45);
        set.add(58);
        set.add(57);
        set.add(59);

        System.out.println(set.tailSet(57));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
//        System.out.println(map.putIfAbsent(5, "one"));

//        Set<Map.Entry<Integer, String>> entries = map.entrySet();
//        for (Map.Entry<Integer, String> entry : entries) {
//            System.out.println(entry.getValue());
//        }

        System.out.println(map.replace(1,"dfd"));
    }
}
