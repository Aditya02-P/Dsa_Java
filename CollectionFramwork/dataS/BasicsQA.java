package dataS;
// The code written in here solves the problems which can be solved with simple or a different approach rather than the defined
// approach in the video.
public class BasicsQA {
    public static int timeTBT(int k, int[] arr) {
        int time = 0;
        int i = 0;

        while (true) {
            if (arr[i] > 0) {
                arr[i]--;
                time++;

                if (i == k && arr[k] == 0) {
                    return time;
                }
            }

            i = (i + 1) % arr.length;
        }
    }

    public static void main(String[] args) {
        int[]arr={1,5,2,3,7};
        System.out.println(BasicsQA.timeTBT(2,arr));
    }
}
