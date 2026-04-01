package List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FirstList {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("The Size is: "+list.size());
        System.out.println(list.getFirst());
        list.remove(1);
        System.out.println(list);
        System.out.println(list.contains(10));
        list.set(1,100);
        System.out.println(list);
    }
}
