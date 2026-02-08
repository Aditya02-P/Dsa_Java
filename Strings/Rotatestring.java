import java.util.Arrays;

public class Rotatestring {

    public static void main(String[] args) {
        char[] name = {'a', 'e', 'i', 'o', 'u'};
        rotateClock(name,3);
        rotateAntiClock(name,3);
        System.out.println("Original Array Unchanged: "+Arrays.toString(name));
    }
    static void rotateClock(char[] name, int rotate) {
        if (rotate < 0 || rotate >= name.length) {
            return;
        }
        while (rotate != 0) {
            char temp = name[name.length - 1];

            for (int i = name.length - 1; i > 0; i--) {
                name[i] = name[i - 1];
            }

            name[0] = temp;
            rotate--;
        }

        System.out.println("After right rotation: " + Arrays.toString(name));

    }

    static void rotateAntiClock(char[] arr,int rotate) {
         rotate = arr.length%rotate; // left rotation count

        while (rotate > 0) {
            char temp = arr[0];

            for (int i = 0; i < arr.length - 1; i++) {
//                System.out.println(i);
                arr[i] = arr[i + 1];
            }

            arr[arr.length - 1] = temp;
            rotate--;
        }

        System.out.println("After left rotation: " + Arrays.toString(arr));
    }
}
