public class LC2798 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int emp=0;
        for(int i=0;i<hours.length;i++){
            if(hours[i]>=target){
                emp++;
            }
        }
        return emp;
    }
}
