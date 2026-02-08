public class Missingnum {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 6, 7, 8 };
        int len = arr[arr.length-1];
        int sum = 0;
        for (int elem : arr) {
            sum += elem;
        }
        int actSum = len*(len+1)/2;
        int miss = actSum-sum;
        System.out.println("The Missing Number Is: "+miss);
    }
}
