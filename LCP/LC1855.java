public class LC1855 {
    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                high = mid - 1;
            }
            else if (nums[mid] > target) {
                 low=mid + 1;
            }

        }
        return -1;
    }
    public static int maxDistance(int[]nums1,int[]nums2){
        int n = nums1.length;
        int m = nums2.length;
        int dist=0;
        int i=0,j=0;
        while(i<n && j<m){
            if(nums1[i]<=nums2[j] && i<=j){
                j++;
            }else{
                dist=Math.max(dist,j-i-1);
                while(i<n && nums1[i]>nums2[j]){
                    i++;
                }
                j=i;
            }
        }
        dist=Math.max(dist,j-i-1);
        return dist;
    }
    public static void main(String[] args) {
        int[] nums1 = {55,30,5,4,2};
        int[] nums2 = {100,20,10,10,5};
        int result = maxDistance(nums1,nums2);
        System.out.println(result);
    }
}
