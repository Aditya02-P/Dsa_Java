public class RomanInt {
    static int charToint(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0; // or throw IllegalArgumentException
        };
    }

    public static void main(String[] args) {
        String s = "IV";
        int sum=0;
        for (int i = 0; i < s.length()-1; i++) {
            if(charToint(s.charAt(i)) < charToint(s.charAt(i+1))){
                sum-=charToint(s.charAt(i));
            }
            else {
                sum+=charToint(s.charAt(i));
            }
        }
        sum+=charToint(s.charAt(s.length()-1));
        System.out.println(sum);
    }
}
