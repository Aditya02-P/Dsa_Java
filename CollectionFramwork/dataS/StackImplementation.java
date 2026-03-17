package dataS;

import java.util.*;

/*
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



/*
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
*/



public class StackImplementation {

    public static void reverseArray(Stack<Integer> stack , int[] arr) {
        if(arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        for(int i : arr) {
            stack.push(i);
        }
        int i =0;
        while (!stack.isEmpty()) {
            arr[i] = stack.pop();
            i++;
        }
    }

    public static void insertAtBottom(Stack<Integer> stack, int data) {
        if(stack.isEmpty()) {
            stack.push(data);
        }
       Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        stack.push(data);
        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }

    }

    public static Stack<Integer> arrToStack(int[]arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i : arr) {
            stack.push(i);
        }
        return stack;

    }

    public static ArrayList<Integer> beautifyArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i : arr) {
            if (stack.isEmpty() || (stack.peek() >= 0 == i >= 0)) {
                stack.push(i);
            } else {
                stack.pop();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);
        return list;
    }

    public static boolean validParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')'){
              if(stack.isEmpty()){
                  return false;
              }
              stack.pop();
            }
            else{
                break;
            }
        }
        return stack.isEmpty();
    }

    public static void minParenthesesValid(String str) {
        int openNeeded = 0;  // Brackets we need to add at the start
        int balance = 0;     // Current net open brackets

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                balance++;
            } else {
                if (balance > 0) {
                    balance--; // Match an existing open bracket
                } else {
                    openNeeded++; // Found a ')' with no '(' to match it
                }
            }
        }

        if (openNeeded == 0 && balance == 0) {
            System.out.println(str + " is a valid parentheses string.");
        } else {
            System.out.println("Additions required:");
            System.out.println("- Open brackets needed: " + openNeeded);
            System.out.println("- Close brackets needed: " + balance);
        }
    }

    public static void displayStack(Stack<Integer> stack) {
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("The stack has become empty after displaying");
    }
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        int[] arr = {1, 2, 3, 4, 5};
//        reverseArray(stack, arr);
//        System.out.println(Arrays.toString(arr));
//        Stack<Integer> stack2 = arrToStack(arr);
//        insertAtBottom(stack2, 5);
//        displayStack(stack2);
//        ArrayList <Integer> list = beautifyArray(new int[]{2,3,5,-4,6,-2,-8,9});
//        System.out.println(list);
//        System.out.println(validParentheses(")("));
        minParenthesesValid("(())))");

    }
}
