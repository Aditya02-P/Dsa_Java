import java.security.spec.RSAOtherPrimeInfo;

public class LongestPalli {
    static int findLongestPalli(String str) {
        int[]count = new int[256];
        boolean isOdd = false;
        for(char c : str.toCharArray()){
            count[c]++;
        }
        int sum=0;
        for(int i=0;i<count.length;i++){
            if(count[i]%2==0){
                sum+=count[i];
            }
            else if(count[i]%2!=0){
                sum += count[i] - 1;
                isOdd = true;
            }
        }
        return isOdd?sum+1:sum;
    }
    public static void main(String[] args) {
        String str="aabcdeebaa  ";
        int ans = findLongestPalli(str);
        System.out.println(ans);
    }
}
