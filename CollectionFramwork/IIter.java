import java.util.*;

class NamesContainer implements Iterable<String> {
    private String[] names;
    private int len;
    NamesContainer(String[] names) {
        this.names = names;
        this.len = this.names.length;
    }

    @Override
    public Iterator<String> iterator() {
        return new NamesContainerItr();
    }

    private class NamesContainerItr implements Iterator<String> {

        int pos=0;
        @Override
        public boolean hasNext() {
            return pos!=len;
        }

        @Override
        public String next() {
            return names[this.pos++];
        }
    }
}

public class IIter {
    public static void main(String[] args) {
        /*
        Iterable<Integer> iterable=new ArrayList<>();
        iterable= Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (Integer integer : iterable) {
            System.out.println(integer);
        }
        LinkedList<Integer> linkedList=new LinkedList<>();

         */
        String[] names = new String[]{"a","b","c","d","e","f","g"};
        NamesContainer namesContainer = new NamesContainer(names);
        Iterator<String> iterator = namesContainer.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}



