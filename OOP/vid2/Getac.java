package vid2;
import access.Access;

public class Getac extends Access {
    Getac(int num,String name){
        super(num,name);
        System.out.println("Getac");
    }
    double getnum(){
        return num;
    }
    int getnum(String name){
        System.out.println("getnum"+name);
        return num;
    }

}
class Access1 extends Getac{
    Access1(int num,String name){
        super(num,name);
        System.out.println("access 1");

    }

    public static void main(String[] args) {
        Access1 obj = new Access1(22,"aditya");
        System.out.println(obj.num);;
        int num = obj.getnum("aditya");

    }
}
