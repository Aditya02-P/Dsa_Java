import java.util.Objects;
import java.util.Scanner;

class AC implements Cloneable {
    int dataOfInstallation;
    String name;

    AC(int data, String name) {
        this.dataOfInstallation = data;
        this.name = name;
    }

    @Override
    protected AC clone() throws CloneNotSupportedException {
        return (AC) super.clone();
    }
}

enum DaysOfWeek {
    SUNDAY(10),
    MONDAY(20),
    TUESDAY(30),
    WEDNESDAY(40),
    THURSDAY(50),
    FRIDAY(60),
    SATURDAY(70);
    private final int temperature;

    DaysOfWeek(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}


public class Basics3 {
    public static void main(String[] args) throws CloneNotSupportedException {
//        AC ac = new AC(1, "John");
//        AC ac2=  ac.clone();
//        System.out.println(ac2.dataOfInstallation);
//        DaysOfWeek d1 = DaysOfWeek.SUNDAY;
//        DaysOfWeek d2 = DaysOfWeek.SUNDAY;
//        System.out.println(d2.getTemperature());
//        String a = "Aditya";
//        String b=a.concat(" Smile");
//        System.out.println(a);
//        System.out.println(b);
        String b="java";
        String a;
        Scanner sc = new Scanner(System.in);
        a=sc.nextLine();
        System.out.println(Objects.equals(a, b));
        DaysOfWeek[]arr=DaysOfWeek.values();


    }
}
