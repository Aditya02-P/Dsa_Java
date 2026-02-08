public class FindIndex {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int f = findindex(arr, 8,true);
        int l = findindex(arr, 8,false);
        System.out.println(f+","+l);
        // System.out.println(Arrays.toString(ans));
    }

    static int[] findflIndez(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int f = -1, l = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                f = mid;
                end = mid - 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        }
        start = 0;
        end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                l = mid;
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        }

        return new int[] { f, l };
    }

    static int findindex(int[] arr, int target, boolean firstIndex) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
            else{
                ans=mid;
                if(firstIndex){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}
