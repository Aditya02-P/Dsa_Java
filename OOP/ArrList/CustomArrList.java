package ArrList;

import java.util.Arrays;

public class CustomArrList {
    int[] arr;
    private static int DEFAULT_CAPACITY = 10;
    public int size=0;

    public CustomArrList() {
        this.arr = new int[DEFAULT_CAPACITY];
    }
    public void add(int num){
        if(size==arr.length){
            this.arr = Arrays.copyOf(this.arr,DEFAULT_CAPACITY*2);
        }
        this.arr[size++]=num;
    }
    public void remove(){
        this.size--;
        System.out.println("Item Removed");
    }

    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public boolean isFull(){
        return this.size==arr.length;
    }
    public void display(){
        for(int i=0;i<this.size;i++){
            System.out.print(this.arr[i]+" ");
        }
    }
    public void displayFull(){
        for(int i=0;i<this.arr.length;i++){
            System.out.print(this.arr[i]+" ");
        }
    }

}
