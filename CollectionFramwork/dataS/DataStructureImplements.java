package dataS;

public class DataStructureImplements {
    public static void main(String[] args) {
        //LinkedList
        /*
        LinkedList head = null;
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
         */

            int[] arr = {1,2,3,4,5,6};
            LinkedList list = LinkedList.arrToLinkedList(arr);
//            LinkedList.printList(list,1);
//            LinkedList.deleteNodeRecursive(list,2);
//            LinkedList.printList(list,1);
//            LinkedList temp = LinkedList.nodeAddress(list,2);
//            LinkedList.deleteNodeWithoutHead(temp);
//            LinkedList.printList(list,1);
//        list=LinkedList.reverseLinkedList(list);
        LinkedList.printList(list,1);
//        list = LinkedList.reverseLinkedListRecursive(list,null);
//        LinkedList.printList(list,1);
        LinkedList mid = LinkedList.findMiddleNode(list);
        System.out.println("mid="+mid.data);


    }
}
