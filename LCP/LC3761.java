import java.util.HashMap;
import java.util.Map;

public class LC3761 {
    public int reverse(int num){
        int ans = 0;
        while(num != 0){
            ans = ans * 10 + num % 10;
            num /= 10;
        }
        return ans;
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                minDist = Math.min(minDist, i - map.get(nums[i]));
            }

            map.put(reverse(nums[i]), i);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
