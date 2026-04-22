public class LC2078 {
    public static int maxDistance(int[] colors) {
        int i=0,j=1;
        int distF=0;
        while(i<colors.length && j<colors.length){
            if(colors[i]!=colors[j]){
                distF=Math.max(distF,j-i);
                j++;
            }else
                j++;
        }
        i=colors.length-1;j=colors.length-2;
        int distB=0;
        while(i>=0 && j>=0){
            if(colors[i]!=colors[j]){
                distB=Math.max(distB,Math.abs(j-i));
                j--;
            }else
                j--;
        }
        return Math.max(distF,distB);
    }

    public static void main(String[] args) {
        int[] colors={1,1,1,6,1,1,1};
        System.out.println(maxDistance(colors));
    }
}
