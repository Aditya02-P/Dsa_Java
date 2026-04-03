package dataS;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class Q{
    int[]arr;
    int front;
    int rear;
    Q(int size){
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueu(int val) {
        // 1. Check for Overflow
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        // 2. Handle first insertion
        if (this.front == -1) {
            this.front = 0;
        }
        this.arr[++this.rear] = val;
    }

    public int deque() {
        // 1. Check for Underflow
        if (isEmpty()) {
            System.out.println("The Queue is Empty");
            // Reset pointers if queue becomes empty
            this.front = this.rear = -1;
            return -1;
        }

        int val = this.arr[this.front++];

        // 2. Reset if  just removed the last item
        if (this.front > this.rear) {
            this.front = this.rear = -1;
        }
        return val;
    }

    public int peek() {
       if(isEmpty()){
           System.out.println("Queue is Empty");
           return -1;
       }
       return this.arr[this.front];
    }

    public boolean isFull() {
        return this.rear == this.arr.length - 1;
    }
    public boolean isEmpty() {
        return this.front == -1;
    }

}

class CQ {
    int front, rear, size;
    int[] arr;

    CQ(int size) {
        this.arr = new int[size];
        this.size = size;
        this.front = -1;
        this.rear = -1;
    }

    public int cqSize() {
        if (this.front == -1) {
            return 0;
        }
        if (this.front <= this.rear) {
            return this.rear - this.front + 1;
        } else {
            return (this.size - (this.front - this.rear - 1));
        }
    }


    boolean isEmpty() {
        return this.front == -1;
    }

    public boolean isFull() {
        return (this.rear + 1) % size == this.front;
    }

    public void enqueu(int val) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        if (isEmpty()) {
            this.front = 0;
        }
        this.rear = (this.rear + 1) % size;
        this.arr[this.rear] = val;
    }

    public int deque() {
        if (isEmpty()) {
            System.out.println("The Queue is Empty");
            return -1;
        }

        int val = this.arr[this.front];

        if (this.front == this.rear) {
            this.front = this.rear = -1;
        } else {
            this.front = (this.front + 1) % size;
        }
        return val;
    }

    /*
    public void printCQ() {
        if (isEmpty()) {
            System.out.println("The Queue is Empty");
            return;
        }
        int size = cqSize();
        while(size != 0){
            System.out.println(this.arr[this.front]);
            enqueu(deque());
            size--;
        }
    }
     */

    public void printCQ() {
        if (isEmpty()) {
            System.out.println("The Queue is Empty");
            return;
        }

        int count = cqSize();
        int currentIdx = this.front; // Start temporary pointer at the front

        for (int i = 0; i < count; i++) {
            System.out.println(this.arr[currentIdx]);
            currentIdx = (currentIdx + 1) % this.size;
        }
    }

    public void reveresCQ() {
        if (isEmpty()) {
            System.out.println("The Queue is Empty");
            return;
        }
        Stack<Integer> stack = new Stack<>();
        while(!this.isEmpty()) {
            stack.push(this.deque());
        }
        while (!stack.isEmpty()) {
            this.enqueu(stack.pop());
        }
    }

    public void reverseFKCq(int k) {
        if(k>cqSize()){
            System.out.println("Invalid K");
            return;
        }
        if (isEmpty()) {
            System.out.println("The Queue is Empty");
            return;
        }
        Stack<Integer> stack = new Stack<>();
        while(k>0){
            stack.push(this.deque());
            k--;
        }
        int n = this.cqSize();
        while(!stack.isEmpty()){
            this.enqueu(stack.pop());
        }
        while(n>0){
            this.enqueu(this.deque());
            n--;
        }
    }
}

class QueueStack{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    QueueStack(){}
    public boolean isempty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public void  push(int val){
        stack1.push(val);
    }
    public int pop(){
        if(isempty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}


public class Queuee {
    public static void main(String[] args) {
        CQ cq = new CQ(10);
        cq.enqueu(1);
        cq.enqueu(2);
        cq.enqueu(3);
        cq.enqueu(4);
        cq.enqueu(5);
//        cq.printCQ();
//        cq.reveresCQ();
//        cq.printCQ();
        cq.reverseFKCq(2);
        cq.printCQ();


    }
}
