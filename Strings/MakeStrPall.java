public class MakeStrPall {
    static int findMInPallChar(String str) {
        String newS=str+"$"+ new StringBuilder(str).reverse().toString();
        int len=0,i=1;
        int[]lps=new int[newS.length()];
        lps[0]=0;
        while(i<newS.length()){
            if(newS.charAt(len)==newS.charAt(i)){
                len++;
                lps[i++]=len;
            }
            else{
                if(len!=0) {
                    len = lps[len - 1];
                }
                lps[i]=0;
                i++;
            }
        }
        int ans=str.length()-lps[lps.length-1];
        StringBuilder sb=new StringBuilder(str).reverse();
        System.out.println(sb.substring(0,ans));
        System.out.println(sb.substring(0,ans)+str);
        return ans ;
    }
    public static void main(String[] args) {
        String str ="ABCD";
        int ans=findMInPallChar(str);
        System.out.println(ans);
    }
}
