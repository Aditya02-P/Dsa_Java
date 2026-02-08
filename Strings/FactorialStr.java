import java.util.ArrayList;
import java.util.Collections;

public class FactorialStr {

    // Multiplies the number in the list by the integer 'num'
    static ArrayList<Character> multiply(ArrayList<Character> list, int num) {
        int carry = 0;

        // Multiply each digit in the list by num
        for (int i = 0; i < list.size(); i++) {
            int digit = list.get(i) - '0';
            int product = (digit * num) + carry;

            list.set(i, (char) ((product % 10) + '0')); // Update current position
            carry = product / 10;                      // Pass carry to next position
        }

        // Add remaining carry digits to the end of the list
        while (carry > 0) {
            list.add((char) ((carry % 10) + '0'));
            carry /= 10;
        }

        return list;
    }

    public static void main(String[] args) {
        int n = 20; // Example: 20!
        ArrayList<Character> result = new ArrayList<>();
        result.add('1'); // Start with 1

        for (int i = 2; i <= n; i++) {
            result = multiply(result, i);
        }

        // Since we stored digits in reverse (ones place at index 0), reverse to print
        Collections.reverse(result);

        System.out.print(n + "! = ");
        for (char c : result) {
            System.out.print(c);
        }
    }
}