class A{
    private int bal ;
    private int check=0;
    A(int bal){
        this.bal=bal;
    }
    private int showBal(){
        check++;
        System.out.println("bal is "+this.bal);
        System.out.println("check is: "+this.check);
        return bal;

    }
    public void show(){
        int a =showBal();
        System.out.println("show is: "+a);
    }

}
class B extends A{
    int idk;
    B(int bal,int idk){
        super(bal);
        this.idk=idk;
    }
//    void showBal(){
//        System.out.println("This is from B");
//    }
    public void showA(){
        System.out.println("idk is: "+idk);
        super.show();
    }

}



public class Exp {
    public static void main(String[] args) {
        A ref = new B(10,20);
        B refb = (B)ref;
        refb.showA();
    }
}
