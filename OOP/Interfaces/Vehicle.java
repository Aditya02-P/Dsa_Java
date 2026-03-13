package Interfaces;

public interface Vehicle {
    default void vehicle(){
        System.out.println("I'm vehicle");
    }
    static void stat(){
        System.out.println("I'm stat");
    }

    void start();
    void stop();
    void accelerate();
    void drive();
    void engine();
}
