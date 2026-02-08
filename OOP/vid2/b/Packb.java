package vid2.b;
class Bullshit{
    static int a;
    static int b;
    static {
        System.out.println(a+":"+b);
        System.out.println("Bullshit is being called in the main method");
        a=123;
        b=456;
    }
    Bullshit(){
        System.out.println("Bullshit is being created....");
    }


}

public class Packb {
    public static void main(String[] args) {
        Bullshit horeseshit = new Bullshit();
        System.out.println(horeseshit.a+":"+horeseshit.b);
    }
}
