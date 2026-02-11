public class Basics {
    static void print(int n){
        if(n == 0){
            System.out.println("Finally I Got The Job");
            return;
        }
        System.out.println(n+" Days Left Till I Get The Job.");
        print(n - 1);
    }
    static void printRev(int n){
        if(n == 0){
            System.out.println("0 Days I Got The Job");
            return;
        }
        printRev(n - 1);
        System.out.println(n+" Days Left Till I Get The Job.");
    }
    static void printEven(int n){
        if(n == 0){
            System.out.println("Even Number: "+0);
            return;
        }
        printEven(n - 1);
        if(n % 2 == 0){
            System.out.println("Even Number: "+n);
        }

    }

    static int powerof(int n,int m){
        if(m == 1)
            return 2;
        return n * powerof(n,m - 1);
    }

    static int sumSN(int n){
        if(n == 1)
            return 1;
        return n*n + sumSN(n-1);
    }

    public static void main(String[] args) {
//        print(10);
//        printRev(10);
//        printEven(10);
        System.out.println(powerof(5,2));
        System.out.println(sumSN(5));
    }
}
