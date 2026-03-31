package dataS;
/*
THIS IMPLEMENTATION IS DONE PURLY OUT OF THINKING HOW CAN I IMPLEMENT 2 STACKS IN ONE ARRY , THOUGH THERE ARE LIMITATION AND NOT THE BEST
APPROACH I DID IT TO TEST MY SKILLS.

Two Stacks in One Array
Stores two independent stacks in a single array index using mathematical packing.

How It Works
Both stacks share the exact same index using this formula:
Array_Value = (Stack1_Value * upperLimit) + Stack2_Value

Stack 1: Added via multiplication (* upperLimit). Read via integer division (/).

Stack 2: Added directly. Read via modulo (%).

Clean Pops: Popped values are mathematically subtracted, leaving the other stack's data untouched.

Drawbacks
Positive Integers Only: Negative numbers break the math.

Strict Ceiling: Pushing a value >= upperLimit corrupts the shared data.

Wasted Space: Both pointers grow upward together. They don't dynamically fill empty space.

Overflow Risk: Large upper limits or values can easily exceed Java's 32-bit integer max.
 */
class TSA{
    int st1ptr;
    int st2ptr;
    int[]arr;
    int upperLimit;
    int size;
    TSA(int size,int maxVal){
        this.st1ptr=-1;
        this.st2ptr=-1;
        this.arr=new int[size];
        this.size=size;
        this.upperLimit=maxVal+1;
    }

    public void pushStack1(int val){
        if(this.st1ptr==this.size-1){
            System.out.println("Stack overflow for stack1");
            return;
        }
        else{
            this.arr[++this.st1ptr]+=val*this.upperLimit;
        }
    }

    public int popStack1(){
        if(this.st1ptr==-1){
            System.out.println("Stack underflow for stack1");
            return -1;
        }
        int val= this.arr[this.st1ptr]/ this.upperLimit;
        this.arr[this.st1ptr--]-=val*this.upperLimit;
        return val;
    }

    public void pushStack2(int val){
        if(this.st2ptr==this.size-1){
            System.out.println("Stack overflow for stack1");
            return;
        }
        else{
            this.arr[++this.st2ptr]+=val;
        }
    }

    public int popStack2(){
        if(this.st2ptr==-1){
            System.out.println("Stack underflow for stack1");
            return -1;
        }
        int val= this.arr[this.st2ptr]%this.upperLimit;
        this.arr[this.st2ptr--]-=val;
        return val;

    }

    public int peekStack1(){
        if(this.st1ptr==-1){
            System.out.println("Stack underflow for stack1");
            return -1;
        }
        return this.arr[this.st1ptr]/this.upperLimit;
    }

    public int peekStack2(){
        if(this.st2ptr==-1){
            System.out.println("Stack underflow for stack1");
            return -1;
        }
        return this.arr[this.st2ptr]%this.upperLimit;
    }
}

public class TwoStackArr {
    public static void main(String[] args) {
        TSA tsa=new TSA(10,99);
        tsa.pushStack1(1);
        tsa.pushStack2(2);
        tsa.pushStack1(3);
        tsa.pushStack2(4);
        tsa.pushStack1(5);
        tsa.pushStack2(6);
        tsa.pushStack1(7);
        tsa.pushStack2(8);
        System.out.println(tsa.popStack1());
        System.out.println(tsa.popStack1());
        System.out.println(tsa.popStack1());
        System.out.println(tsa.popStack1());
        System.out.println(tsa.popStack2());
        System.out.println(tsa.popStack2());

    }
}
