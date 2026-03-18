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


    public static boolean validParentheses2(String str) {
        if (str.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                } else if (ch == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (ch == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (ch == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean validParentheses3(String str) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                char top= stack.isEmpty() ? '#' : stack.pop();
                if (top != map.get(ch)) {
                    return false;
                }
            } else if (map.containsValue(ch)) {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static boolean backStrCheck(String s1, String s2) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        String s1f=pushValid(s1, stack1);
        String s2f=pushValid(s2, stack2);
        return s1f.equals(s2f);
    }

    private static String  pushValid(String s, Stack<Character> stack) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.toString();
    }

    /*
    In the below implementation there is an edge case where if number of opening brackets are more it's not throwing an error.So the correct implementation i need to
    throw an error if there are more opening brackets.
    ->It can be solved by checking if the stack is empty or not after the loop finishes , in the below implementation it can't be done as i am printing the char on the go.
    so the corrected implementation is right after this commented code.

    public static void printBracketNum(String s){
        int count=1;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==')'){
                if(!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
                else {
                    System.out.println("Invalid bracket");
                    return;
                }
            }else if(ch=='('){
                System.out.print(count);
                stack.push(count++);
            }
            else{
                System.out.print(ch);
            }
        }
    }


    }

     */


    public static String getBracketNum(String s) {
        int count = 1;
        // Using the modern, faster Deque instead of the legacy Stack
        Stack<Integer> stack = new Stack<>();

        // StringBuilder is highly efficient for appending characters in a loop
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                result.append(count);
                stack.push(count++);
            }
            else if (ch == ')') {
                if (!stack.isEmpty()) {
                    result.append(stack.pop());
                } else {
                    return "Invalid bracket"; // Caught an extra closing bracket
                }
            }
            else {
                result.append(ch);
            }
        }

        // Edge Case Fix: Were any opening brackets left unclosed?
        if (!stack.isEmpty()) {
            return "Invalid bracket";
        }

        return result.toString();
    }

    public static void printMinPop(int[] arr) {
        // Use separate stacks for each call to ensure they start empty
        Stack<Integer> mainstack = new Stack<>();
        Stack<Integer> minstack = new Stack<>();

        for (int j : arr) {
            mainstack.push(j);
            if (minstack.isEmpty() || j <= minstack.peek()) {
                minstack.push(j);
            }
        }

        while (!mainstack.isEmpty()) {
            // 1. The current minimum is always safely at the top of minstack
            int currentMin = minstack.peek();

            // 2. Remove the top element from the main stack
            int poppedValue = mainstack.pop();

            System.out.println("Popped: " + poppedValue + " | Minimum was: " + currentMin);

            if (poppedValue == currentMin) {
                minstack.pop();
            }
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
//        minParenthesesValid("(())))");
//        System.out.println(validParentheses3("[[{}{}]]]"));
//        System.out.println(backStrCheck("ab#c#","ad#c#f"));
//        printBracketNum("(abcd(ef)gh)");
//        System.out.println(getBracketNum("(abcd(ef)gh)"));
        printMinPop(new int[]{2,3,5,1,4,0,7,8,9});
    }
}
