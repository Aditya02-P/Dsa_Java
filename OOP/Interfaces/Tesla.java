package Interfaces;

public class Tesla implements Vehicle {
    @Override
    public void accelerate() {
        System.out.println("IT's fast as fuck boy");
    }
    @Override
    public void drive() {
        System.out.println("IT's slow drive");
    }
    @Override
    public void engine() {
        System.out.println("I'm engining. My quad electric enigine");
    }
    @Override
    public void start(){
        System.out.println("I'm starting. My quad electric enigine");
    }
    @Override
    public void stop(){
        System.out.println("I'm stoping. My quad electric enigine");
    }
}
