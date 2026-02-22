import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(result, sb, 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result,
                                  StringBuilder sb,
                                  int open, int close, int max) {

        // Base case
        if (sb.length() == max * 2) {
            result.add(sb.toString());
            return;
        }

        // Try adding '('
        if (open < max) {
            sb.append('(');
            backtrack(result, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1); // UNDO
        }

        // Try adding ')'
        if (close < open) {
            sb.append(')');
            backtrack(result, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1); // UNDO
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}