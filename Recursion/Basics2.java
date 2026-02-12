public class Basics2 {

    static void printArr(int[] arr,int start,int end) {
        if(end>=arr.length) {
            System.out.println("Not Possible");
            return;
        }
        if (start==end) {
            System.out.println(arr[start]);
            return;
        }
        System.out.println(arr[start]);
        printArr(arr,start+1,end);
    }

    static int sumOFAll(int[] arr,int start,int end) {
        if(end>=arr.length) {
            System.out.println("Invalid Index");
            return -1;
        }
        if (start==end) {
            return arr[start];
        }
        return arr[start] + sumOFAll(arr,start+1,end);
    }

    static int findMin(int[]arr,int n){
        if(n==0) {
            return arr[n];
        }
        return Math.min(arr[n],findMin(arr,n-1));
    }

    static boolean checkPal(String s, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        return checkPal(s, start + 1, end - 1);
    }

    static int countVowel(String s , int index){
        if(index==-1){
            return 0;
        }
        if(s.charAt(index)=='a'||s.charAt(index)== 'e'||s.charAt(index)=='i'|| s.charAt(index)=='o'||s.charAt(index)=='u'){
            return 1+countVowel(s, index-1);
        }
        return countVowel(s,index-1);
    }



    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        printArr(arr,0,arr.length);
        String s="abccba";
        System.out.println(sumOFAll(arr,0,arr.length-1));
        System.out.println(findMin(arr,arr.length-1));
        System.out.println(checkPal(s,0,s.length()-1));
        System.out.println(countVowel(s,s.length()-1));
    }
}
