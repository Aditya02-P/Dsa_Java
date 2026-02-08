import java.util.*;

public class Sortvowelbrute {
    public static void main(String[] args) {
        String s = "leetcode";
        String ans="";
        ArrayList<Character> vowList=new ArrayList<>();
        Set<Character> vowels = Set.of(
                'a','e','i','o','u',
                'A','E','I','O','U'
        );
        for(char c:s.toCharArray()){
            if(vowels.contains(c)){
                vowList.add(c);
            }
        }
        Collections.sort(vowList);
        int i=0;
        for(char c:s.toCharArray()){
            if(vowels.contains(c)){
                ans+=vowList.get(i++);
            }
            else {
                ans+=c;
            }
        }
        System.out.println("Ans is: "+ans);
    }
}
