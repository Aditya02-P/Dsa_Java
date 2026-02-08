class BankData{
    static int custCount;
    String custName="";
    String pass="";
    int id;
    BankData(String name , String pass){
        this.custName=name;
        this.pass=pass;
        custCount++;
        this.id = custCount*((int)(Math.random() * 10)+1);

    }

    void showDetail(){
        System.out.println("The Name Of Customer:"+this.custName);
        System.out.println("The Password Of Customer: "+this.pass);
        System.out.println("Customer Id: "+this.id);
    }

}


public class Bank {

    public static void main(String[] args) {
        BankData c1 = new BankData("Aditya","123456");
        c1.showDetail();
        BankData c2 = new BankData("Aditya","123456");
        c2.showDetail();
        System.out.println(c1);

    }
}
