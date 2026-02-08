import java.util.ArrayList;
import java.util.Collections;

public class Addstrnum {

    public static void main(String[] args) {

        String a = "123456";
        String b = "   456";

        int carry = 0;
        int sum = 0;

        ArrayList<Character> list = new ArrayList<>();

        char[] a1 = a.trim().toCharArray();
        char[] b1 = b.trim().toCharArray();

        int index1=a1.length-1,index2=b1.length-1;

        while(index2>=0){
            sum=(a1[index1]-'0')+(b1[index2]-'0')+carry;
            carry=sum/10;
            list.add((char)((sum%10)+'0'));
            index1--;
            index2--;
        }

        while(index1>=0){
            sum=(a1[index1]-'0')+carry;
            carry=sum/10;
            list.add((char)((sum%10)+'0'));
            index1--;
        }

        if(carry!=0){
            list.add((char)(carry+'0'));
        }

        Collections.reverse(list);
        System.out.println(list);

    }
}
