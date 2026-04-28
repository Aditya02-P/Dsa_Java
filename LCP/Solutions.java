import java.util.Arrays;

class Solution {
    public static int minOperations(int[][] grid, int x) {
        int m=grid.length;
        int n=grid[0].length;
        int elem=m*n;
        int k=0;
        int[]arr=new int[elem];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[k++]=grid[i][j];
            }
        }
        System.out.println(Arrays.toString(arr));
        int mid= (arr.length) / 2;
        int median=(int)Math.ceil(arr[mid]);
        System.out.println(median);
        int op=0;
        for (int j : arr) {
            int o = Math.abs(j - median) / x;
            System.out.println(j + " " + o);
            op += o;

        }
        return op;
    }

    public static void main(String[] args) {
        int[][] grid=new int[][]{{2,4},{6,8}};
        System.out.println(minOperations(grid,2));
    }
}