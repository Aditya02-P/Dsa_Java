package dataS;

public class NStack {
    private int[] arr;   // Stores actual values
    private int[] top;   // Stores indices of top elements of N stacks
    private int[] next;  // Stores next entry in stack or next free slot
    private int free;    // Points to the first available index in arr
    private int n, s;

    public NStack(int N, int S) {
        this.n = N;
        this.s = S;
        arr = new int[s];
        top = new int[n];
        next = new int[s];

        // Initialize all stacks as empty (-1 indicates null/empty)
        for (int i = 0; i < n; i++) {
            top[i] = -1;
        }

        // Initialize all slots as free and link them together
        free = 0;
        for (int i = 0; i < s - 1; i++) {
            next[i] = i + 1;
        }
        next[s - 1] = -1; // End of the free slots list
    }

    // Push x into the m-th stack (0-indexed)
    public boolean push(int x, int m) {
        if (free == -1) {
            return false; // Array is full (Stack Overflow)
        }

        // 1. Find the index where we can insert
        int i = free;

        // 2. Update the free pointer to the next available slot
        free = next[i];

        // 3. Link the new element to the current top of stack 'm'
        next[i] = top[m];

        // 4. Update the top of stack 'm' to this new index
        top[m] = i;

        // 5. Insert the actual value
        arr[i] = x;

        return true;
    }

    // Pop from the m-th stack (0-indexed)
    public int pop(int m) {
        if (top[m] == -1) {
            return -1; // Stack is empty (Stack Underflow)
        }

        // 1. Find the index of the top element
        int i = top[m];

        // 2. Update top to point to the element below it
        top[m] = next[i];

        // 3. Link this vacated slot back into the free list
        next[i] = free;
        free = i;

        return arr[i];
    }
}


