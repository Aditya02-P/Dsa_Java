import java.util.Arrays;

public class Pangrambrute {
    public static void main(String[] args) {
        boolean[] alphabet = new boolean[26];
        String sentence="quick brown fox jumps over the lazy dog";
        for(int i=0;i<sentence.length();i++){
//            System.out.println(sentence.charAt(i)-'a');
            if(sentence.charAt(i)==' '){
                continue;
            }
            alphabet[sentence.charAt(i)-'a']=true;
        }
        for (boolean b : alphabet   ) {
            if (!b) {
                System.out.println("Every Character Not found");
                break;
            }
        }
        System.out.println(Arrays.toString(alphabet));
        System.out.println("The Sentence Contain Every Character");
    }
}
