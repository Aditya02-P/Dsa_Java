import java.util.Arrays;

public class Sortsentence {
    public static void main(String[] args) {

        String sen = "Myself4 Me1 I2 And3";
        String[] senArr = sen.split(" ");

        String[] result = new String[senArr.length];

        for (String str : senArr) {
            int index = str.charAt(str.length() - 1) - '0';
            result[index - 1] = str.substring(0, str.length() - 1);
        }

        System.out.println(Arrays.toString(result));
    }
}
