package dataS;

public class DataStructureImplements {
    public static void main(String[] args) {
        //LinkedList
        /*
         head = null;
        head = LinkedList.addLast(head, 0);
        head = LinkedList.addLast(head, 1);
        head = LinkedList.addLast(head, 2);
        head = LinkedList.addLast(head, 3);
        head = LinkedList.addLast(head, 4);
        head = LinkedList.addLast(head, 5);

        LinkedList.printList(head,0);
        System.out.println();

        head = LinkedList.addFirst(head, 6);
        LinkedList.printList(head,0);
        System.out.println();
        int[] arr = {1,2,3,4,5};
        LinkedList list = LinkedList.arrToLinkedList(arr);
        LinkedList.printList(list,1);
        LinkedList list2= LinkedList.arrToLinkedList2(arr);
        LinkedList.printList(list2,2);
        System.out.println();
        LinkedList list3;
        list3=LinkedList.RecursiveLastAddArrToLinked(arr);
        LinkedList.printList(list3,3);
        System.out.println();
        LinkedList list4 = LinkedList.arrToLinkedListRecFirstAdd(arr);
        LinkedList.printList(list4,4);
        list4=LinkedList.deleteAtIndex(list4,0);
        LinkedList.printList(list4,4);


        int[] arr = {1,2,3,4,5,6,7,8,9};
        LinkedList list = LinkedList.arrToLinkedList(arr);
        LinkedList.printList(list,1);
        LinkedList.deleteNodeRecursive(list,2);
        LinkedList.printList(list,1);
        LinkedList temp = LinkedList.nodeAddress(list,2);
        LinkedList.deleteNodeWithoutHead(temp);
        LinkedList.printList(list,1);
        list=LinkedList.reverseLinkedList(list);
        LinkedList.printList(list,1);
        list = LinkedList.reverseLinkedListRecursive(list,null);
        LinkedList.printList(list,1);
        LinkedList mid = LinkedList.findMiddleNode(list);
        System.out.println("mid="+mid.data);
        list = LinkedList.removeEveryKth(list,3);
        LinkedList.printList(list,1);
      list = LinkedList.rotateList(list,3);
      LinkedList.printList(list,1);
         */

        /*
        Doubly LinkedList

        DoublyLinkedList list ;
        int[]arr={1,3,4,5};
        list=DoublyLinkedList.arrToDLinkedList(arr);
        DoublyLinkedList.display(list);
        list=DoublyLinkedList.reverse(list);
        DoublyLinkedList.display(list);
        list=DoublyLinkedList.arrToDLinkedListRecursive(arr);
        DoublyLinkedList.display(list);
        list = DoublyLinkedList.addAtIndex(list,2,2);
        DoublyLinkedList.display(list);

        LinkedList list = LinkedList.arrToLinkedList(new int[] {2,2,2,3,4,4});
        list=LinkedList.removeDuplicates(list);
        LinkedList.display(list);

        LinkedList list1= LinkedList.arrToLinkedList(new int[] {1,2,3,4,5});
        LinkedList list2= LinkedList.arrToLinkedList(new int[] {5,6,7,8,9});
        LinkedList list3 = LinkedList.mergeSortedList(list1,list2);
        LinkedList.display(list3);
        LinkedList list1 = LinkedList.arrToLinkedList(new int[] {1,2,6,3,4,5,6});
        LinkedList list2 = LinkedList.removeElements(list1,6);
        LinkedList.display(list2);

         */
        //Circular Singly Linked List
        CircularLL list1 = CircularLL.arrToCircularLL(new int[]{1,2,3,4,5});
        CircularLL.display(list1);
        list1=CircularLL.addFirst(list1,1);
        CircularLL.display(list1);





    }
}
