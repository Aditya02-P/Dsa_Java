class Abasics{
    int a;
    String name;
    Abasics(int a,String name){
        this.a=a;
        this.name=name;
    }
    Abasics(Abasics a){
        this.a=a.a;
        this.name=a.name;
    }
    public static void info(Abasics a){
        System.out.println(a.a+" "+a.name);
    }

}

public class Basics2 {
    public static void main(String[] args) {
        Abasics a=new Abasics(1,"a");
        Abasics.info(a);
        Abasics b = new Abasics(a);
        Abasics.info(b);
    }
}



