import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Dogg<T >{
    String name;
    T obj;
    public Dogg(String name,T obj){
        this.name=name;
        this.obj=obj;
    }

    public T getObj(){
        return obj;
    }

    public void setObj(T obj){
        this.obj=obj;
    }

    public String getName(){
        return this.name;
    }
}

class Animal{
    int age;
    Animal(int age){
        this.age=age;
    }

    public static void printCats(List< ? extends Animal>arr){
        for(Animal a:arr){
            a.eat();
        }
    }


    public void eat(){
        System.out.println("Animal is eating");
    }



}


class Cat extends Animal {
    String name;
    int age;
    public Cat(String name,int age){
        super(age);
        this.name=name;
        this.age=age;
    }

    public void eat(){
        System.out.println(this.name+" is eating");
    }

    public Cat getCat(Cat o){
        return new Cat(o.name,o.age);
    }
}

class Notcat{
    String name;
    int age;
    public Notcat(String name,int age){
        this.name=name;
        this.age=age;
    }

    public Cat getCat(Cat o){
        return new Cat(o.name,o.age);
    }
}



public class Basics5 {
    public static void main(String[] args) {
        /*

        Cat c = new Cat("Smile",99);
        Notcat d = new Notcat("Smile",99);
        Dogg<Cat>e= new Dogg<>("Aditya",c);
        Dogg<Cat> e1 = e;
        Dogg<Notcat> e2 = e;
        int a =5;
        System.out.printf("%d",a++ + ++a);

        This is not possible as the memory block inside the arr are of type Cat, and we are trying to access arr[0] which is of
        parent animal type is being referenced by child type cat so it break the rule of Polymorphism.
        Cat[] arr = new Cat[5];
        Animal[] animals =arr;
        arr[0]=new Animal(12); <-- trying to insert Animal(Parent) type obj to Cat(child) type reference

         */

        Cat[] arr = new Cat[5];
        for(int i=0;i<5;i++){
            arr[i]=new Cat("cat"+i,i){
                final int rand=(int)(Math.random()*10);
                public void eat(){
                    System.out.println("cat is eating"+"bullshit"+this.name+this.rand);
                }
            };
        }
        List<Cat>  list=new ArrayList<Cat>(List.of(arr));
        Animal.printCats(list);



    }
}
