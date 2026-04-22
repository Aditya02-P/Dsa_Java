import java.util.ArrayList;
import java.util.List;

public class LC2452 {
    public boolean checkEditDist(String q, String dict) {
        int k = 0;
        for (int i = 0; i < dict.length(); i++) {
            if (q.charAt(i) != dict.charAt(i)) {
                k++;
                if (k > 2) {
                    return false;
                }
            }
        }
        return true;

    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<String>();
        int k = 0;
        for (String q : queries) {
            for (String dict : dictionary) {
                if (checkEditDist(q, dict)) {
                    list.add(q);
                    break;
                }
            }
        }
        return list;
    }
}
