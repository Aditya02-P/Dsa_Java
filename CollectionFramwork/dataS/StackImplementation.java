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

    public static void reverseArray(Stack<Integer> stack, int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        for (int i : arr) {
            stack.push(i);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            arr[i] = stack.pop();
            i++;
        }
    }

    public static void insertAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
        }
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        stack.push(data);
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

    }

    public static Stack<Integer> arrToStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            stack.push(i);
        }
        return stack;

    }

    public static ArrayList<Integer> beautifyArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (stack.isEmpty() || (stack.peek() >= 0 == i >= 0)) {
                stack.push(i);
            } else {
                stack.pop();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);
        return list;
    }

    public static boolean validParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            } else {
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
            } else {
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
                char top = stack.isEmpty() ? '#' : stack.pop();
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
        String s1f = pushValid(s1, stack1);
        String s2f = pushValid(s2, stack2);
        return s1f.equals(s2f);
    }

    private static String pushValid(String s, Stack<Character> stack) {
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
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    result.append(stack.pop());
                } else {
                    return "Invalid bracket"; // Caught an extra closing bracket
                }
            } else {
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


    /*this below code is another implementation of popping min element without using any extra stack memory and purely
        relies on arithmetic way storing 2 numbers in one container . For this to work there should be a bound of
        elements that can be there inside the array, for the below code the limit is between x belongs to [1,100)  .
     */

    public static void printMinPop2(int[] arr) {
        Stack<Integer> mimstack = new Stack<>();
        for (int elem : arr) {
            if (mimstack.isEmpty()) {
                mimstack.push(elem * 100 + elem);
            } else {
                int min = Math.min(mimstack.peek() % 100, elem);
                mimstack.push(elem * 100 + min);
            }
        }
        while (!mimstack.isEmpty()) {
            int currentMin = mimstack.pop() % 100;
            System.out.println("Mim popped: " + currentMin);
        }
    }

    public static int[] nextGreaterElement(int[] arr) {
        int[] res = new int[arr.length];
        ngeSB(res, arr);
        return res;
    }

    private static void ngeSB(int[] res, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && (arr[stack.peek()] < arr[i])) {
                res[stack.peek()] = arr[i];
                stack.pop();
            }
            res[i] = -1;
            stack.push(i);
        }
    }

    public static int[] nextSmallerElement(int[] arr) {
        int[] res = new int[arr.length];
        nseSB(res, arr);
        return res;
    }

    private static void nseSB(int[] res, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && (arr[stack.peek()] >= arr[i])) {
                res[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
    }

    public static int[] nextSmallerFromLeftElement(int[] arr) {
        int[] res = new int[arr.length];
        nseleftSB(res, arr);
        return res;
    }

    private static void nseleftSB(int[] res, int[] arr) {
        /*This implementation checks literally from left, though it's correct we have to change the logic which differs from the above logic.
        We can use the above logic to solve this question also, we just need to check the array from behind rather than start.
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && (stack.peek()>arr[i])) {
                stack.pop();
            }
            if(!stack.isEmpty()){
            res[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
         */
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && (arr[i] < arr[stack.peek()])) {
                res[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
    }

    public static int[] stockSpan(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];
        // The stack stores indices of the days, not the actual prices
        Stack<Integer> stack = new Stack<>();

        // The span of the very first day is always 1
        spans[0] = 1;
        stack.push(0);

        // Process the rest of the days
        for (int i = 1; i < n; i++) {
            // Remove indices of days with prices less than or equal to the current day
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack becomes empty, then prices[i] is greater than all elements to its left
            if (stack.isEmpty()) {
                spans[i] = i + 1;
            } else {
                // prices[i] is greater than the elements after the top of the stack
                spans[i] = i - stack.peek();
            }

            // Push this element's index to stack to be evaluated for future days
            stack.push(i);
        }

        return spans;
    }

    public static int largestRect(int[] arr) {
        int n = arr.length;
        int left = 0, right = 0;
        int[] rightMax = new int[n];
        int[] leftMax = new int[n];
        Stack<Integer> stack = new Stack<>();
        //next smallest right
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                rightMax[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) rightMax[stack.pop()] = n;
        stack.clear();
        //next smallest left neighbor
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                leftMax[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) leftMax[stack.pop()] = -1;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int height = arr[i];
            int width = rightMax[i] - leftMax[i] - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    public static int largestRect2(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // Use a virtual height of 0 at the end (i == n) to flush the stack
            int currentHeight = (i == n) ? 0 : arr[i];

            while (!stack.isEmpty() && currentHeight < arr[stack.peek()]) {
                int h = arr[stack.pop()]; // The height of the bar we are calculating

                // If stack is empty, this bar was the smallest so far
                // Its width is the entire distance from index 0 to i
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }


    public static void displayStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("The stack has become empty after displaying");
    }

    public static int[] maxInWinBrute(int[] arr) {
        //it has a time complexity of BigOh(n^3)
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int num = Integer.MAX_VALUE;
                for (int k = j; k < j + i + 1; k++) {
                    num = Math.min(num, arr[k]);
                }
                res[i] = Math.max(res[i], num);
            }
        }
        return res;
    }


    public static int[] maxInWinLinear(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] left = new int[n];  // Stores PSE indices
        int[] right = new int[n]; // Stores NSE indices

        // Step 1: Find the Previous Smaller Element (PSE) for each arr[i]
        for (int i = 0; i < n; i++) {
            // Pop elements greater than or equal to current element
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            // If stack is empty, no smaller element exists on the left
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        s.clear(); // Reset stack for the next pass

        // Step 2: Find the Next Smaller Element (NSE) for each arr[i]
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            // If stack is empty, no smaller element exists on the right
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        // Step 3: Map elements to their maximum window sizes
        // We use size n+1 because window sizes range from 1 to n (1-based index for now)
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1; // Calculate max window size for arr[i]
            res[len] = Math.max(res[len], arr[i]);
        }

        // Step 4: Fill in the gaps (The cascading step)
        // Some window sizes might not have been updated directly.
        for (int i = n - 1; i >= 1; i--) {
            res[i] = Math.max(res[i], res[i + 1]);
        }

        // Convert the 1-based index array back to the expected 0-based result format
        int[] finalRes = new int[n];
        for (int i = 1; i <= n; i++) {
            finalRes[i - 1] = res[i];
        }

        return finalRes;
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
//        printMinPop(new int[]{2,3,5,1,4,0,7,8,9});
//        int[]arr={7,9,12,10,14,8,3,6,9};
//        int[] res=nextGreaterElement(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(res));
        // Example prices over 7 days
//
//        int[] prices = {100, 80, 60, 70, 60, 75, 85};
//        int[] spans = stockSpan(prices);
//
//        System.out.println("Prices: " + Arrays.toString(prices));
//        Expected output: [1, 1, 1, 2, 1, 4, 6]
//        System.out.println("Spans:  " + Arrays.toString(spans));
//        int max = largestRect2(arr);
//        System.out.println("The Max Rectangle Area is : "+max);
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(Arrays.toString(maxInWinBrute(arr)));
    }
}
