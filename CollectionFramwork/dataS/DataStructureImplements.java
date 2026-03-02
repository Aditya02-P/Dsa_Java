package dataS;
class LinkedList {
    int data;
    LinkedList next;

    LinkedList(int data) {
        this.data = data;
        this.next = null;
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

    public static void printList(LinkedList head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
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
}
public class DataStructureImplements {
    public static void main(String[] args) {

        LinkedList head = null;
        head = LinkedList.addLast(head, 0);
        head = LinkedList.addLast(head, 1);
        head = LinkedList.addLast(head, 2);
        head = LinkedList.addLast(head, 3);
        head = LinkedList.addLast(head, 4);
        head = LinkedList.addLast(head, 5);

        LinkedList.printList(head);
        System.out.println();

        head = LinkedList.addFirst(head, 6);
        LinkedList.printList(head);
        System.out.println();
        int[] arr = {1,2,3,4,5};
        LinkedList list = LinkedList.arrToLinkedList(arr);
        LinkedList.printList(list);
        LinkedList list2= LinkedList.arrToLinkedList2(arr);
        LinkedList.printList(list2);
    }
}
