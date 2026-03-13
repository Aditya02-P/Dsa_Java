package dataS;

public class MultiLevelLinkedList {

    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int data) {
            this.data = data;
            next = null;
            bottom = null;
        }
    }

    static Node mergeLists(Node first, Node second) {

        Node dummy = new Node(0);
        Node tail = dummy;

        while (first != null && second != null) {

            if (first.data <= second.data) {
                tail.bottom = first;
                first = first.bottom;
            } else {
                tail.bottom = second;
                second = second.bottom;
            }

            tail = tail.bottom;
        }

        if (first != null) {
            tail.bottom = first;
        } else {
            tail.bottom = second;
        }

        return dummy.bottom;
    }
    static Node flatten(Node head) {
        Node root=head;
        Node head1,head2,head3;
        while (root.next != null) {
            head1=root;
            head2=root.next;
            head3=root.next.next;
            head1.next=null;
            head2.next=null;
            root=mergeLists(head1,head2);
            root.next=head3;
        }
        return head;
    }

    public static void main(String[] args) {

        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);
        head.next.next.next.next = new Node(30);

        // 5 -> 7 -> 8 -> 30
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        // 10 -> 20 -> 40
        head.next.bottom = new Node(20);
        head.next.bottom.bottom = new Node(40);

        // 19 -> 22 -> 50
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        // 28 -> 35 -> 40 -> 45
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        // 30 -> 34 -> 40
        head.next.next.next.next.bottom = new Node(34);
        head.next.next.next.next.bottom.bottom = new Node(40);

        Node temp=flatten(head);
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.bottom;
        }
    }
}