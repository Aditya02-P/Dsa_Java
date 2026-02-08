package Generics;

public class Box<T extends Number> {
    private T value;
    public Box(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
    public void gV(T val){
        System.out.println("VAl:"+val);
    }
    public <T extends Double> void gV(T val){
        System.out.println("This is from generic function");
        System.out.println("VAl:"+val);
    }

}
