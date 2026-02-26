import java.util.Scanner;

public class TowerOFHanoi {
    static void towerOfHanoi(int n,int source,int help,int destination){
        if(n==1){
            System.out.println("Move Disk-"+n+" from "+source+"->"+destination);
            return;
        }
        towerOfHanoi(n-1,source,destination,help);
        System.out.println("Move Disk-"+n+" from "+source+"->"+destination);
        towerOfHanoi(n-1,help,source,destination);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int source = input.nextInt();
        int help = input.nextInt();
        int destination = input.nextInt();
        towerOfHanoi(n,source,help,destination);
    }
}
