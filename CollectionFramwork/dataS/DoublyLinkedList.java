/*
package dataS;

public class DoublyLinkedList {
    DoublyLinkedList prev;
    int data;
    DoublyLinkedList next;
    public DoublyLinkedList(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public static void display(DoublyLinkedList list){
        if(list==null){
            System.out.println("list is null");
            return;
        }
        while (list!=null){
            System.out.print(list.data+" ");
            list=list.next;
        }
    }

    public static DoublyLinkedList addFirst(DoublyLinkedList head,int data) {
        if(head==null){
            return new DoublyLinkedList(data);
        }
        DoublyLinkedList newNode = new DoublyLinkedList(data);
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    public static DoublyLinkedList addLast(DoublyLinkedList head,int data) {
        if (head == null) {
            return new DoublyLinkedList(data);
        }
        DoublyLinkedList newNode = new DoublyLinkedList(data);
        DoublyLinkedList curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr;
        return newNode;
    }

    public static DoublyLinkedList removeFirst(DoublyLinkedList head) {
        if (head == null) {
            return null;
        }
        DoublyLinkedList curr = head;
        curr=curr.next;
        curr.prev = null;
        return curr;
    }
    public static DoublyLinkedList removeLast(DoublyLinkedList head) {
        if (head == null) {
            return null;
        }
        DoublyLinkedList curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr=curr.prev;
        curr.next = null;
        return head;
    }

    public static DoublyLinkedList addAtIndex(DoublyLinkedList head,int index,int data) {
        if (head == null) {
            return new DoublyLinkedList(data);
        }
        DoublyLinkedList curr = head;
        int count = 1;
        while (curr != null && count != index-1) {
            curr = curr.next;
            count++;
        }
        DoublyLinkedList newNode = new DoublyLinkedList(data);
        newNode.prev = curr;
        newNode.next = curr.next;
        curr.next.prev = newNode;
        curr.next = newNode;
        return head;
    }

    public static DoublyLinkedList removeAtIndex(DoublyLinkedList head,int index) {
        if (head == null) {
            return null;
        }
        DoublyLinkedList curr = head;
        int count = 1;
        while (curr!=null && count != index-1) {
            curr = curr.next;
            count++;
        }
        DoublyLinkedList temp = curr;
        curr.next=curr.next.next;
        curr=curr.next.next;
        curr.prev=temp;
        return head;

    }

    public static DoublyLinkedList arrToDLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        DoublyLinkedList head = new DoublyLinkedList(arr[0]);
        DoublyLinkedList curr = head;
        for (int i = 1; i < arr.length; i++) {
            DoublyLinkedList newNode = new DoublyLinkedList(arr[i]);
            newNode.prev = curr;
            curr.next = newNode;
            curr = curr.next;
        }
        return head;
    }

    public static DoublyLinkedList arrToDLinkedListRecursive(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        DoublyLinkedList head =recursiveArrToDLLMethod(arr,0,null);
        return head;
    }

    private static DoublyLinkedList recursiveArrToDLLMethod(int[] arr,int index,DoublyLinkedList prev) {
        if (index == arr.length-1) {
            DoublyLinkedList newNode = new DoublyLinkedList(arr[index]);
            newNode.prev = prev;
            return newNode;
        }
        DoublyLinkedList newNode = new DoublyLinkedList(arr[index]);
        newNode.prev=prev;
        newNode.next = recursiveArrToDLLMethod(arr,index+1,newNode);
        return newNode;
    }



}
 */

//the above code is before solving edge cases
//the below code is after solving edge cases

package dataS;

public class DoublyLinkedList {
    DoublyLinkedList prev;
    int data;
    DoublyLinkedList next;

    public DoublyLinkedList(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public static void displayDL(DoublyLinkedList list) {
        if (list == null) {
            System.out.println("list is null");
        }
        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }
    }

    public static DoublyLinkedList addFirst(DoublyLinkedList head, int data) {
        if (head == null) {
            return new DoublyLinkedList(data);
        }
        DoublyLinkedList newNode = new DoublyLinkedList(data);
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    public static DoublyLinkedList addLast(DoublyLinkedList head, int data) {
        if (head == null) {
            return new DoublyLinkedList(data);
        }
        DoublyLinkedList newNode = new DoublyLinkedList(data);
        DoublyLinkedList curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }

    public static DoublyLinkedList removeFirst(DoublyLinkedList head) {
        if (head == null) return null;

        if (head.next == null) return null;

        DoublyLinkedList newHead = head.next;
        newHead.prev = null;
        head.next = null;

        return newHead;
    }

    public static DoublyLinkedList removeLast(DoublyLinkedList head) {
        if (head == null) return null;

        if (head.next == null) return null;

        DoublyLinkedList curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.prev.next = null;
        curr.prev = null;

        return head;
    }

    public static DoublyLinkedList addAtIndex(DoublyLinkedList head, int index, int data) {
        if (head == null || index == 0) {
            return addFirst(head, data);
        }

        DoublyLinkedList curr = head;
        int count = 0;

        // Traverse to the node JUST BEFORE the insertion point
        while (curr != null && count < index - 1) {
            curr = curr.next;
            count++;
        }

        if (curr == null) {
            System.out.println("Index out of bounds");
            return head;
        }

        DoublyLinkedList newNode = new DoublyLinkedList(data);
        newNode.next = curr.next;
        newNode.prev = curr;

        // Only update the 'next' node's prev pointer if the next node actually exists
        if (curr.next != null) {
            curr.next.prev = newNode;
        }
        curr.next = newNode;

        return head;
    }

    public static DoublyLinkedList removeAtIndex(DoublyLinkedList head, int index) {
        if (head == null) return null;
        if (index == 0) return removeFirst(head);

        DoublyLinkedList curr = head;
        int count = 0;

        // Traverse exactly to the node we want to delete
        while (curr != null && count < index) {
            curr = curr.next;
            count++;
        }

        if (curr == null) {
            System.out.println("Index out of bounds");
            return head;
        }

        // Re-wire neighboring nodes to skip 'curr'
        if (curr.prev != null) curr.prev.next = curr.next;
        if (curr.next != null) curr.next.prev = curr.prev;

        // Clean up the deleted node's pointers
        curr.next = null;
        curr.prev = null;

        return head;
    }

    public static DoublyLinkedList arrToDLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        DoublyLinkedList head = new DoublyLinkedList(arr[0]);
        DoublyLinkedList curr = head;
        for (int i = 1; i < arr.length; i++) {
            DoublyLinkedList newNode = new DoublyLinkedList(arr[i]);
            newNode.prev = curr;
            curr.next = newNode;
            curr = curr.next;
        }
        return head;
    }

    public static DoublyLinkedList arrToDLinkedListRecursive(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        return recursiveArrToDLLMethod(arr, 0, null);
    }

    private static DoublyLinkedList recursiveArrToDLLMethod(int[] arr, int index, DoublyLinkedList prev) {
        if (index == arr.length) {
            return null;
        }
        DoublyLinkedList newNode = new DoublyLinkedList(arr[index]);
        newNode.prev = prev;
        newNode.next = recursiveArrToDLLMethod(arr, index + 1, newNode);
        return newNode;
    }
}
