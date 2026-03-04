package dataS;

public class LinkedList {
    int data;
    LinkedList next;

    LinkedList(int data) {
        this.data = data;
        this.next = null;
    }

    public static LinkedList nodeAddress(LinkedList node,int index){
        int count = 0;
        while(node!=null && count<index){
            node = node.next;
            count++;
        }
        if(node==null){
            System.out.println("Index out of bounds");
            return null;
        }
        return node;
    }

    public static LinkedList addFirst(LinkedList head, int data) {
        if (head == null) {
            return new LinkedList(data);
        }
        LinkedList temp = new LinkedList(data);
        temp.next = head;
        return temp;
    }

    public static LinkedList addLast(LinkedList head, int data) {
        if (head == null) {
            return new LinkedList(data);
        }
        LinkedList curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new LinkedList(data);
        return head;
    }

    public static void printList(LinkedList head,int num) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("This Is "+num+"th list");
    }

    public static LinkedList arrToLinkedList(int[] arr) {
        LinkedList head = null;
        for (int val : arr) {
            head = addLast(head, val);
        }
        return head;
    }

    public static LinkedList arrToLinkedList2(int[] arr) {
        if (arr.length == 0) return null;

        LinkedList head = null;
        LinkedList tail = head;
        for (int val : arr) {
            if (head == null) {
                head = addFirst(head, val);
                tail=head;
            }
            else {
                tail.next = new LinkedList(val);
                tail = tail.next;
            }

        }
        return head;
    }

    public static LinkedList RecursiveLastAddArrToLinked(int[] arr) {
        LinkedList head;
        head = arrToLinkedListRecursive(arr, 0);
        return head;
    }

    public static LinkedList arrToLinkedListRecursive(int[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }

        LinkedList node = new LinkedList(arr[index]);
        node.next = arrToLinkedListRecursive(arr, index + 1);
        return node;
    }

    public static LinkedList arrToLinkedListRecFirstAdd(int[] arr) {
        LinkedList head ;
        head = arrToLinkedListaddNodeFirst(arr,0,null);
        return head;
    }

    public static LinkedList arrToLinkedListaddNodeFirst(int[] arr,int index,LinkedList prev) {
        if (index == arr.length) {
            return prev;
        }
        LinkedList node = new LinkedList(arr[index]);
        node.next=prev;
        return arrToLinkedListaddNodeFirst(arr,index+1,node);
    }

    public static LinkedList addAtIndex(LinkedList head, int index, int data) {

        if (index < 0) {
            return head;
        }

        if (index == 0) {
            LinkedList newNode = new LinkedList(data);
            newNode.next = head;
            return newNode;
        }

        LinkedList temp = head;
        int count = 0;

        while (temp != null && count < index - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            return head; // index out of bounds
        }

        LinkedList newNode = new LinkedList(data);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    public static LinkedList deleteAtIndex(LinkedList head, int index) {
        if (index == 0) {
            head=head.next;
            return head;
        }
        LinkedList temp = head;
        int count = 0;
        while (temp != null && count < index - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Index Out of Bound");
            return head;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static LinkedList deleteFirst(LinkedList head) {
        if (head == null || head.next == null) {
            return null;
        }
        return head.next;
    }

    public static LinkedList deleteLast(LinkedList head) {
        if (head == null || head.next == null) {
            return null;
        }
        LinkedList temp = head;
        LinkedList prev = head;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return head;    
    }

    public static LinkedList deleteNodeRecursive(LinkedList node, int index) {
        if (index == 0) {
            System.out.println("index reached");
            return node.next;
        }

        node.next=deleteNodeRecursive(node.next,index-1);
        return node;
    }

    public static void deleteNodeWithoutHead(LinkedList node) {
        if (node == null || node.next == null) {
            System.out.println("node is null");
            return;
        }
        node.data=node.next.data;
        node.next=node.next.next;
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        if (head == null || head.next == null) {
            System.out.println("it runs");
            return head;
        }
//        LinkedList prev=null;
//        LinkedList curr=head;
//        LinkedList next=head.next;
//        while (next!=null){
//            curr.next=prev;
//            prev=curr;
//            curr=next;
//            next=next.next;
//        }
//        curr.next=prev;
//        return curr;
        LinkedList prev = null;
        LinkedList curr = head;
        LinkedList next = null;
        while (curr != null) {
            next = curr.next; // store next node
            curr.next = prev;            // reverse link
            prev = curr;                 // move prev forward
            curr = next;                 // move curr forward
        }

        return prev;
    }

    public static LinkedList reverseLinkedListRecursive(LinkedList curr,LinkedList prev) {
        if(curr==null){
            return prev;
        }
        LinkedList next = curr.next;
        curr.next = prev;
        return reverseLinkedListRecursive(next,curr);
    }

    public static LinkedList findMiddleNode(LinkedList head) {

        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        LinkedList midPtr = head;
        while(head!=null){
            count++;
            if(count%2==0){
                midPtr = midPtr.next;
            }
            head = head.next;
        }
        return midPtr;
        //it can be optimized by using slow fast pointer where the fast pointer moves twice the speed of slow pointer , it is essentially same as above but it avoids
        //calculating the count%2 , if condition saving us cpu cycles making the calculation faster.
        /*
        LinkedList slow=head;
        LinkedList fast=head;
        while(fast!=null @@ fast.next==null){
            slow=slow.next;
            fast=fast.next.next;
        }
         */
    }




}
