import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NestedClass {
    public static void main(String[] args) throws IOException {
//        Outer outer=new Outer();
//        outer.print();
//        Outer.Inner inner=new Outer.Inner();
//        inner.print();
//        System.err.println("This is an error message");
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }

        Scanner in = new Scanner(System.in);
        int age = in.nextInt();
        System.out.println("You are " + age + " years old." );




    }
}


class Outer{
    int x=1;

    void print(){
        System.out.println("Hello From Outer");
    }

    static class Inner{
        void print(){
            System.out.println("Hello From Inner");
        }
    }
}

