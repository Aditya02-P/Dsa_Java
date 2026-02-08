public class Pangrambrute2 {
    public static void main(String[] args) {
        boolean[] alphabet = new boolean[26];
        String sentence="quick brown fox jumps over the lazy dog";
        int charCount=0;
        for(int i=0;i<sentence.length();i++){
            if(sentence.charAt(i)==' '){
                continue;
            }
            boolean b = alphabet[sentence.charAt(i) - 'a'];
            if(!b){
                alphabet[sentence.charAt(i)-'a']=true;
                charCount++;
            }
            if(charCount==26){
                break;
            }
        }
        System.out.println(charCount);
        if(charCount==26){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
