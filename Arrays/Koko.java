public class Koko {
    public static void main(String[] args) {
        int[] piles = {123};
        int hours = 8;
        int speed = eatBanana(piles, hours);
        System.out.println("Min Speed is: " + speed);
    }

    public static int eatBanana(int[] piles, int hours) {
        int start = 1;
        int end = 0;

        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        int ans = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPossible(piles, mid, hours)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] piles, int speed, int hours) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed;
        }
        return time <= hours;
    }
}
