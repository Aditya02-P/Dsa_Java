package Generics.det;

public class Boxdet<T extends String> {
    private T t;
    public Boxdet(T t) {
        this.t = t;
    }
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
    public void printBox(){
        System.out.println(this.t.length());
    }


}
