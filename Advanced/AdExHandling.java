import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AdExHandling {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        //case - > both try have their catch block
        try {
            int rand = (int) Math.floor(Math.random() * 10);
            int index = arr[rand];
            try {
                int value = arr[index + 3];
                System.out.println(value);

            } catch (ArrayIndexOutOfBoundsException e) {
                //Avoid nested try-catch block , it's a bad programming practice
                System.out.println("Error by inner catch block"+e.getMessage());
                try {
                    System.out.println("Enter a value between 0 and 7");
                    int in = new Scanner(System.in).nextInt();
                    System.out.println(arr[in]);
                }catch (ArrayIndexOutOfBoundsException | NullPointerException f){
                    System.err.println("Invalid Input");
                }
            }


        } catch (Exception e) {
            System.err.println("Caught by outer try block"+e.getMessage());
        }finally {
            System.out.println("All engines running , lift off successful");
        }
        try {
            readFile();
        }catch (FileNotFoundException e){
            System.err.println("Error by inner catch block"+e.getMessage());
        }


        try {
            checkEligibility(17);
        }catch (InvalidAgeException e){
            System.out.println("Invalid Age");
            System.out.println("Entered age was: "+e.getAge());

        }

    }

    private static void checkEligibility(int age){
        if(age<18){
            throw new InvalidAgeException("Invalid Age",age);
        }
        System.out.println("Eligibility for Voting found to be true");
    }


    private static void readFile() throws FileNotFoundException {
        File file = new File("file.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

    }

}
class InvalidAgeException extends RuntimeException {
    private final int age;
    public InvalidAgeException(String message,int age) {
        super(message);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
