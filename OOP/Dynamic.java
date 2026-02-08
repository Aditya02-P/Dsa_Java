class Par {
    int a;

    Par(int a) {
        this.a = a;
    }

    void area() {
        System.out.println("The Area Is: " + this.a);
    }
}

class Child extends Par {
    int a;

    Child(int a, int b) {
        super(a);
        this.a = b;
    }
    @Override
    void area() {
        System.out.println("Area Of Child Is:"+this.a);
    }
}

public class Dynamic {
    public static void main(String[] args) {
        Par p = new Par(10);
        p.area();
        Child c = new Child(10, 20);
        c.area();
    }
}
