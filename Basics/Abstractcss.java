abstract class Car{
    abstract void start();
    abstract void end();
}
class Car2 extends Car{
    public void start(){
        System.out.println("Inside Car2 start");
    }
    public void end(){
        System.out.println("Inside Car2 end");
    }
}


public class Abstractcss {
    public static void main(String[] args) {
        Car c1= new Car2();
//        Car c2 = new Car();
        c1.start();
    }

}
