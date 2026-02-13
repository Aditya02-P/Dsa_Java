public class BinaraySeRe {
    static int binarySearch(int[]arr,int start,int end,int key){
        int mid=start+(end-start)/2;
        if (arr[mid]==key){
            return mid;
        }
        if(key<arr[mid]){
            return binarySearch(arr,start,mid-1,key);
        }
        else if(key>arr[mid]){
            return binarySearch(arr,mid+1,end,key);
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]arr={1,2,3,4,6,7,8,9};
        System.out.println(binarySearch(arr,0,arr.length-1,9));
    }
}
