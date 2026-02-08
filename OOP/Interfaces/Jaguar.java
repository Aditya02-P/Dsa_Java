package Interfaces;

public class Jaguar implements Vehicle {
    @Override
    public void accelerate() {
        System.out.println("Jaguar is accelerating");
    }
    @Override
    public void drive() {
        System.out.println("Jaguar is driving");
    }
    @Override
    public void stop() {
        System.out.println("Jaguar is stopping");
    }
    @Override
    public void start() {
        System.out.println("Jaguar is starting");
    }
    @Override
    public void engine() {
        System.out.println("Jaguar is engining it's v8 8.2l biturob charege");
    }
}
