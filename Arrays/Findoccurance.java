public class Findoccurance {
    public static void main(String[] args) {
        int[]arr={1,2,3,3,3,3,4,5,6,7};
        int target=3;
        int fi=findIndex(arr,target,false);
        int li=findIndex(arr,target,true);
        int ans =(li-fi)+1;
        System.out.println("Total Occurance: "+ans);
    }
    static int findIndex(int[]arr,int target,boolean flag){
        int start=0,end=arr.length-1;
        int index=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==target){
                index=mid;
                if(flag){
                    //find last index
                    start=mid+1;
                }
                else {
                    //find last index
                    end=mid-1;
                }
            }
            else if(arr[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return index;
    }
}
