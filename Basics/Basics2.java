///*
//class Abasics{
//    int a;
//    String name;
//    static String college;
//    Abasics(int a,String name){
//        this.a=a;
//        this.name=name;
//    }
//    Abasics(Abasics a){
//        this.a=a.a;
//        this.name=a.name;
//    }
//    public static void info(Abasics a){
//        mean();
//        System.out.println(a.a+" "+a.name);
//    }
//    public static void mean(){
//        System.out.println("djdj");
//    }
//
//    public static void print(Abasics a){
//        System.out.println(a.a+" "+a.name+" "+ college);
//    }
//
//
//
//}
//*/
//
//import dataS.DataStructureImplements;
//
//class  AB{
//    int a;
//    String name;
//    AB(){
//        System.out.println("This is default constructor of AB");
//    }
//    AB(int a,String name){
//        this.a=a;
//        this.name=name;
//        System.out.println("This is constructor of AB");
//    }
//
//    public void print(AB a){
//        System.out.println("This is a method of AB");
//        System.out.println(a.name+" " +a.a);
//    }
//}
//
//class BC extends AB{
//    int b;
//    BC(int a,String name,int b){
//        super(a,name);
//        System.out.println("This is default constructor of BC");
//    }
//    public void printBC(BC a){
//        System.out.println("This is a method of BC");
//    }
//}
//
//class Ch{
//    int x,y;
//    Ch(int x,int y){
//        this.x=x;
//        this.y=y;
//    }
//
//    public boolean equals(Ch ch){
//        return this.x == ch.x && this.y == ch.y;
//    }
//}

interface IntFace{
    void fun();
}

class IntCheck implements IntFace{
    @Override
    public void fun() {
        System.out.println("fun");
    }
    public void gm(){
        System.out.println("gm");
    }

}

public class Basics2 {
    public static void main(String[] args) {
        IntCheck obj = new IntCheck();
        obj.fun();
    }
}
//
//
//
