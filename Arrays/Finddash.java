public class Finddash {
    public static void main(String[] args) {
        int dash[] = {6,2,5,5,4,5,6,3,7,6};
        int time = 1020;
        int total = findTotalDash(dash,time);
        System.out.println("Total Dashes Required for : "+time+" Is : "+total);
    }
    static int findTotalDash(int[]dash,int time){
        if(time==0){
            return dash[time];
        }
        int temp=0;
        int sum=0;
        while (time!=0) {
            temp =time%10;
            sum+=dash[temp];
            time = time/10;
        }
        return sum;
    }
}
