package vid2;
abstract class A{
    int num;
    public A(int a)
    {
        this.num=a;
    }
    int  getNum()
    {
        return num;
    }
    abstract int numGet();

}

class Abcc  extends A {
    Abcc(int a)
    {
        super(a);
    }
    @Override
    int  numGet()
    {
        System.out.println("This is Abcc overriden method");
        return num;
    }
    void aVoid()
    {
        System.out.println("This is child specific method");
    }
}
public class Abc {
    public static void main(String[] args) {
        Abcc obj = new Abcc(3);
//        System.out.println(obj.aVoid());
        obj.aVoid();
    }
}