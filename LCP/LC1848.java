public class LC1848 {
    public static int getMinDistance(int[] nums, int target, int start) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                ans=Math.min(ans,Math.abs(i-start));
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
