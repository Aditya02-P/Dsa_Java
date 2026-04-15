public class LC2515 {
    public int closestTarget(String[] words, String target, int startIndex) {
        int distF = 0;
        int distB = 0;
        int n = words.length;
        boolean isP = false;
        int i = startIndex;
        do {
            if (words[i].equals(target)) {
                isP = true;
                break;
            }
            distF++;
            i = (i + 1) % n;
        } while (i != startIndex);
        if (!isP) {
            return -1;
        }
        i=startIndex;
        do {
            if (words[i].equals(target)) {
                isP = true;
                break;
            }
            distB++;
            i = (i - 1+n) % n;
        } while (i != startIndex);

        return Math.min(distF, distB);

    }
}
