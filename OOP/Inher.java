class Box{
    double h,w,l;
    Box(double h, double w, double l){
        super();
        this.h=h;
        this.w=w;
        this.l=l;
    }
    public void info(){
        System.out.println(this.h+":"+":"+this.w+":"+this.l);
    }

}
class Wbox extends Box{
    double weight;
    Wbox(double h, double w, double l,double weight){
        super(h, weight, l);
        this.weight=weight;
    }

    @Override
    public void info(){
        System.out.println("The Weight is : "+this.weight);
    }
}
public class Inher {
    public static void main(String[] args) {
        Wbox box = new Wbox(1,2,3,4);
        box.info();
        System.out.println(box.w);
    }
}
