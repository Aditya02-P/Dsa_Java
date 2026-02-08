public class Findsqrt {
    public static void main(String[] args) {
        int sqrtVal=8;
        int sqrt = findSqrt(sqrtVal);
        System.out.println("The Sqrt Is: "+sqrt);
    }
    static int findSqrt(int sqrtVal){
        int start = 0;
        int end = sqrtVal/2;
        int ans=-1;
        while(start<=end){
            int mid = (start+end)/2;
            int sqmid=mid*mid;
            if(sqmid == sqrtVal){
                return mid;
            }
            else if(sqmid<sqrtVal){
                ans=mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }

        }
        return ans;
    }
}
