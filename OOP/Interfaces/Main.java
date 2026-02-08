package Interfaces;

public class Main {
    public static void main(String[] args) {
        Vehicle pladS = new Tesla();
        pladS.accelerate();
        pladS.drive();
        pladS.engine();
        Vehicle f8 = new Jaguar();
        f8.accelerate();
        f8.drive();
        f8.engine();
        f8.vehicle();
        pladS.vehicle();
        Vehicle.stat();
    }
}
