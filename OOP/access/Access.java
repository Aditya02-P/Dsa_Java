package access;
public class Access {
    protected int num;
    String name;
    int []arr;
    public Access(int a, String name){
        this.num=a;
        this.name=name;
        this.arr=new int[name.length()];
        System.out.println("Access");
    }
}
