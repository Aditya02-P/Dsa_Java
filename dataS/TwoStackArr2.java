package dataS;
class TwoStacks {
    int[] arr;
    int size;
    int st1ptr;
    int st2ptr;

    TwoStacks(int size) {
        this.size = size;
        this.arr = new int[size];
        this.st1ptr = -1;           // Starts before the first index
        this.st2ptr = size;         // Starts after the last index
    }

    public void pushStack1(int val) {
        // As long as there is at least one empty space between them
        if (st1ptr < st2ptr - 1) {
            arr[++st1ptr] = val;
        } else {
            System.out.println("Stack Overflow for Stack 1");
        }
    }

    public void pushStack2(int val) {
        if (st1ptr < st2ptr - 1) {
            arr[--st2ptr] = val;
        } else {
            System.out.println("Stack Overflow for Stack 2");
        }
    }

    public int popStack1() {
        if (st1ptr >= 0) {
            return arr[st1ptr--];
        }
        System.out.println("Stack Underflow for Stack 1");
        return -1;
    }

    public int popStack2() {
        if (st2ptr < size) {
            return arr[st2ptr++];
        }
        System.out.println("Stack Underflow for Stack 2");
        return -1;
    }
}
public class TwoStackArr2 {

}
