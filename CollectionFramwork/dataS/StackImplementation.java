package dataS;

class StackI{
    private int top;
    private int [] arr;
    private int size;
    public StackI(int size){
        this.arr = new int[size];
        this.top = -1;
        this.size = 0;
    }
    public void push(int x){
        if(this.top == this.arr.length-1){
            System.out.println("Stack is full");
            return;
        }
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top--];
    }

    public int peek(){
        if(isEmpty()) {
            System.out.println("Stack is empty");
        }
        return this.arr[this.top];
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == this.arr.length-1;
    }
}
/*
     This is a dumb first implementation of Stack using LinkedList. Though there are several issues i tried to
     implement the stack by extending LinkedList,it worked but there are several issues.Like
     1. Stack is not a LinkedList, but it's extended.
     2. The pop operation takes BigOh(n) time , but it should be BigOh(1) for stack.
     3.Other architectural issues which is not being handled .

     The better approach is written below.



class StackLL extends LinkedList{
    LinkedList head;
    LinkedList tail;
    public StackLL(){
        this.head = null;
        this.tail = null;
    }
    public void push(int x){
        if(isEmpty()){
            this.head = new LinkedList(x);
            this.tail = this.head;
            return;
        }
        tail.next = new LinkedList(x);
        tail = tail.next;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        int val = tail.data;
        LinkedList.deleteLast(head);
        return val;
    }

    public int peek(){
        if (head == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return tail.data;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void displayStack(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        LinkedList.display(head);
    }

}

 */


class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

class StackLL {
    private Node top; // This is our 'head'

    public void push(int x) {
        Node newNode = new Node(x);
        // Point the new node to the current top
        newNode.next = top;
        // Move top to the new node
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int val = top.data;
        top = top.next; // Just move the pointer! No traversal needed.
        return val;
    }

    public int peek() {
        return isEmpty() ? -1 : top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class StackImplementation {
    public static void main(String[] args) {
        StackI stack = new StackI(10);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }
}
