import java.util.Arrays;
import java.util.Objects;

class Outerr{
    static String name="OuterClass";
    private static int rank=1;
    int num;
    Outerr(int num){
        this.num=num;
    }

    public static int getRank() {
        return rank;
    }

    static class Inner{
        Outerr outerr;
        Inner(Outerr outerr){
            this.outerr=outerr;
        }
        public int getNum(){
            return outerr.num;
        }
    }
}

class INIT{
    static int id;
    int objId;
    int num;
    static{
        System.out.println("THE INIT Object is created");
        System.out.println("The object is initiated to 0.");
    }
    {
        id++;
    }
    INIT(int num){
        this.num=num;
    }
    INIT(){
        this.objId=id;
    }
    public int getNum(){
        return this.objId;
    }
}



public class Basics4 {
    public static void main(String[] args) {
//        char[] a ={'a','d','i','t','y','a'};
//        String b = new String(a,0,4);
//        System.out.println(b);
//
//        byte[] b1={97,98,99,100,101,102,103};
//        String c=new String(b1);
//        System.out.println(c);
//        String n1="adityad";
//        System.out.println(n1.replace("ad","d"));
//        String names="aditya,nararyan,pradhan";
//        String[] names1=names.split(",");
//        System.out.println(Arrays.toString(names1));
//        byte []bs=n1.getBytes();
//        System.out.println(Arrays.toString(bs));
//        StringBuilder s=new StringBuilder();
//        s.append("Hello");
//        System.out.println(s.toString());
//        System.out.println(s.capacity());
//        s.trimToSize();
//        System.out.println(s.capacity());
//        Outerr outerr=new Outerr(1);
//        Outerr.Inner inner=new Outerr.Inner(outerr);
//        System.out.println(inner.getNum());
//

//        String ab ="1234";
//        int ac=Integer.parseInt(ab);
//        System.out.println(ac);
//
//        Object a="aditya";
//        String b=a.toString();

        int[]arr={1,2,3,4,5};
        System.out.println(Arrays.toString(arr));




    }
}
