package dataS;

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
        if (this.rear == arr.length - 1) {
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
        if (this.front == -1 || this.front > this.rear) {
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

public class Queuee {
    public static void main(String[] args) {
        Q q = new Q(10);
        q.enqueu(10);
        q.enqueu(20);
        q.enqueu(30);
        q.enqueu(40);
        q.enqueu(50);
        q.enqueu(60);
        System.out.println(q.deque());
        System.out.println(q.deque());
        System.out.println(q.deque());
        System.out.println(q.deque());
    }
}
