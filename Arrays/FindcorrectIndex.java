public class FindcorrectIndex {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8,9,10,12,14,18,22,23,24,25};
        int target = 20;
        int index = findCorrectIndex(arr,target);
        System.out.println(index);
    }
    static int findCorrectIndex(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        int index = end;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>target){
                index = mid;
                end = mid-1;
            }
            else if(arr[mid]<target){
                start = mid+1;
            }

        }
        return index;
    }
}
