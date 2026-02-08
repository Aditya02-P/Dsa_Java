package Generics.det;

public class Doublet <T1 extends String , T2 extends Number >{
    T1 name;
    T2 age;
    public Doublet(T1 name, T2 age) {
        this.name = name;
        this.age = age;
    }
    public T1 getName() {
        return name;
    }
    public void setName(T1 name) {
        this.name = name;
    }
    public T2 getAge() {
        return this.age;
    }
    public void setAge(T2 age) {
        this.age = age;
    }
}
