import javax.xml.transform.Source;

class Ca{
    int a=10;
    public int getA(){
        return a;
    }

}
class Cb extends Ca{
    int a =20;
    public int getA(){
        return a;
    }
}


public class Base {

    static int a(){
        return (int) Math.floor(Math.random()*3+1);
    }


    public static void main(String[] args) {
        /*
        float a=1.7f;
        float b=8.15f;
        System.out.printf("%.10f%n",a);
        System.out.printf("%.10f%n",b);

        casting
        1.implicit conversion -> rule is the dest data type should be wider than the src data type
        byte src=1;
        int dest=src;
        double dest2=src+0.3;
        int src2=300;
        byte dest3=(byte)src2;
        System.out.println("dest="+dest);
        System.out.printf("dest2 %.20f\n",dest2);
        System.out.println(300-127);
        System.out.println("dest3="+dest3);
        //type promotion
        byte a2=127;
        byte b2=127;
        int c = a2*b2;//a2 and b2 are promoted to int for handling overflow
        byte d= (byte) (a2 *b2);
        System.out.println(d);
        System.out.println("c="+c);


        operators
        1.Airthmetic Operators
        2.Reletional Operators--> ==,!=,<,>,<=,>=
        int c1=1,c2=2;
        String c3 = "hello";
        String c4 = "hello";
        boolean d=c1<c2;
        System.out.println(c3.equals(c4));

        System.out.println(c1==c2);

        3.bitwise operator
        int b1=1,b2=44;
        int c =b1|b2;
        int d=b1^b2;
        System.out.println(d);
        System.out.println(c);
        int e=b2<<1 ;
        System.out.println(e);
        byte f=1;
        int k=f<<7;
        System.out.println(k);
        byte g= (byte) (f<<1);
        System.out.println(g);
        //left shifting is basically multiplying by 2
        //right shifting is dividing by 2
        int n=64;
        System.out.println(n<<1);
        System.out.println(n>>1);
        int a =1;
        int b=a<<7;
        System.out.println(b);
        byte c= (byte) (a<<7);
        System.out.println(c);
        byte d= (byte) (c<<8);
        int e =c<<8;
        System.out.println(d);
        System.out.println(e);
        int f=1<< 1;
        System.out.println(f);
        f=f<<1;
        System.out.println(f);
        int a=-64;
        byte b =(yte)(a>>5);
        System.out.println(b);
        byte c=(byte)(a>>>31);//right shift with 0 , introduce msb with 0 instead of the bit in the msb
        System.out.println(c);

        int j =2;
        int k =~j;
        System.out.println(k);

    in java there is short circuiting in logical operators , but if we do not want to sc we can use & , | to prevent sc.


        //flow controle
        //i know if,else so i am skipping it as it same as other language

        //switch statement
        //these are more optimized version of if-else ladder, because how it works under the hood,
        /*if values to be checked are closer together like(1,2,3,4,5) because jvm converts the values to an array and use those values as index
        and stores the address of the code to execute.It is BigOh(1) operation

        if values are not closer together like it creates a sorted array of the values used in switch case, when value is passed it performs
        binarysearch jump to that index and execute the code stored at that array index


        int l=1;
        switch (a()){
            case 1:
                System.out.println("The value is 1");
                break;
            case 2:
                System.out.println("The value is 2");
                break;
            case  3:
                System.out.println("The value is 3");
                break;
            default:
                System.out.println("The value is 4");
        }

        for(int i=1,j=2;i<=10;i+=2,j+=2){
            System.out.println(i*j);
        }
        for(int i=10;i>=0;i--){
            for(int j=0;j<i;j++){
                System.out.print("*  "+"()");
            }
            System.out.println();
        }

         */

        Ca o = new Cb();
        System.out.println(o.getA());





    }
}
