class Sa{
    static void display(){
        System.out.println("Hello from Stat class");
    }
}
class Sb extends Sa{
    static void display(){
        System.out.println("Hello from Sb class");
    }
}

public class Stat {
    public static void main(String[] args) {
        Sa obj1 = new Sa();
        obj1.display();
        Sa obj2 = new Sb();
        obj2.display();
      
    }
}
