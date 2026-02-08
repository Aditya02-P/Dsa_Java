package Generics;

public class Main {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>(1234);
        box.gV(11);
        box.gV(12.2);
    }
}
