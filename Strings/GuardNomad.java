import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuardNomad {
    public static void main(String[] args) {
        String s="QwabqWcdErefTyghYt";
        StringBuilder s1=new StringBuilder();
        Character[] guard = {'q','w','e','r','t','y','Q','W','E','R','T','Y'};
        ArrayList<Character> list1 = new ArrayList<>(Arrays.asList(guard));
        for(char c:s.toCharArray()){
            if(list1.contains(c)){
                continue;
            }
            else {
                s1.append(".").append(c);
            }
        }
        System.out.println(s1);




    }
}
