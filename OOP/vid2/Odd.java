package vid2;

class Genreic<T>{
    T a;
    Genreic(T a){
        this.a=a;
    }
    T getA(){
        return this.a;
    }

}

public class Odd {
    public static void main(String[] args) {
        Genreic<String> genreic=new Genreic<String>(new String("a"));
        System.out.println(genreic.getA());
        Genreic<Integer> intType= new Genreic<>(23);
        System.out.println(intType.getA());
    }
}
