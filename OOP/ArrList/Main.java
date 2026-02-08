package ArrList;

public class Main {
    public static void main(String[] args) {
        CustomArrList list = new CustomArrList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.display();
        list.displayFull();
        list.remove();
        list.display();
    }
}
