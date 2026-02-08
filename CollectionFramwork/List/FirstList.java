package List;

import java.util.ArrayList;

public class FirstList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(100);
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
