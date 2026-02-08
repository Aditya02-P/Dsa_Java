package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }

}
public class LinkedListTest {
    public static void main(String[] args) {
//        Node head=new Node(1);
//        Node n1=new Node(2);
//        n1.next=head;
//        Node n2=new Node(3);
//        n2.next=n1;
//        Node n3=new Node(4);
//        n3.next=n2;
//        Node temp=n3;
//        while(temp!=null){
//            System.out.print(temp.data+" ");
//            temp=temp.next;
//        }

//        List<Integer> list = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addAll(Arrays.asList(4,5,6,7));
        System.out.println(list);

    }

}
