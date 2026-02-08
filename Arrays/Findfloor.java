public class Findfloor {
    public static void main(String[] args) {
        char[]arr={'a','b','c','d','e','f','h','l'};
        System.out.println(findFloor(arr,'g'));
    }
    static char findFloor(char[]arr,char target){
        int start=0,end=arr.length-1;
        char ans = arr[0];
        while (start<=end) {
            int mid =start+(end-start)/2;
            if(arr[mid]==target){
                start=mid+1;
            }
            if(arr[mid]<target){
                ans=arr[mid];
                start=mid+1;
            }
            else if(arr[mid]>target){   
                end=mid-1;
            }
        }
        return ans;
    }
}
