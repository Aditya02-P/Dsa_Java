public class Printpresuf {
    static void printPrefix(String str){
        int fi=0;
        for(int i=0;i<str.length()-1;i++){
            System.out.println(str.substring(fi,i+1));
        }
    }
    static void printSuffix(String str){
        int li=str.length();
        for(int i=str.length()-1;i>0;i--){
            System.out.println(str.substring(i,li));
        }

    }
    static void findLongpresuf(String str){
//        int fi=0,li=str.length()-1;
//        String s1,s2;
//        String ans=null;
//        for(int i=0;i<str.length()-1;i++){
//            s1=str.substring(fi,i+1);
//            System.out.println(s1);
//            s2=str.substring(li-i,li+1);
//            System.out.println(s2);
//            if(s1.equals(s2)){
//                ans=s1;
//            }
//        }
//        System.out.println("The Longest presuf: "+ans);
        String ans = "";

        for (int len = 1; len < str.length(); len++) {
            String prefix = str.substring(0, len);
            String suffix = str.substring(str.length() - len);

            if (prefix.equals(suffix)) {
                ans = prefix;
            }
        }
        System.out.println("The Longest PreSuf is : "+ans);
    }
    public static void main(String[] args) {
        String s="ABCDEABCD";
        printPrefix(s);
        printSuffix(s);
        findLongpresuf(s);
    }
}
