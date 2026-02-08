public class Ipaddress {
    public static void main(String[] args) {
        String address = "255.255.255.0";
        String ans = "";
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i)=='.') {
                ans += "[.]";
            }
            else {
                ans += address.charAt(i);
            }
        }
        System.out.println(ans);

    }
}
