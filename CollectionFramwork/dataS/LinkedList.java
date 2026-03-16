package dataS;
import java.util.ArrayList;
import java.util.HashMap;
public class LinkedList {
    int data;
    LinkedList next;

    LinkedList(int data) {
        this.data = data;
        this.next = null;
    }

    public static void display(LinkedList list) {
        if (list == null) {
            System.out.println("list is null");
            return;
        }
        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }
        System.out.println();
    }

    public static int listSize(LinkedList list) {
        if (list == null) {
            return 0;
        }
        int size = 0;
        while (list != null) {
            size++;
            list = list.next;
        }
        return size;
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

        /*
        LinkedList prev=null;
        LinkedList curr=head;
        LinkedList next=head.next;
        while (next!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next=prev;
        return curr;
        */

        LinkedList prev = null;
        LinkedList curr = head;
        LinkedList next;
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
        /*it can be optimized by using slow fast pointer where the fast pointer moves twice the speed of slow pointer , it is essentially same as above but it avoids
         calculating the count%2 , if condition saves us cpu cycles making the calculation faster.
        LinkedList slow=head;
        LinkedList fast=head;
        while(fast!=null @@ fast.next==null){
            slow=slow.next;
            fast=fast.next.next;
        }
         */
    }

    public static LinkedList removeNthFromEnd(LinkedList head, int n) {
        if(head==null){
            return null;
        }

        LinkedList temp=head;
        int nodes=0;
        while(temp!=null){
            nodes++;
            temp=temp.next;
        }

        int toDelete=nodes-n;
        if(toDelete==0){
            return head.next;
        }

        LinkedList prev=null;
        LinkedList curr=head;
        while(toDelete!=0){
            prev=curr;
            curr=curr.next;
            toDelete--;
        }

        prev.next=curr.next;
        return head;
    }

    public static LinkedList removeEveryKth(LinkedList head, int k) {
        //it's my approach of solving where i need to manually reset the counter every time a nodes get deleted.It can be optimized.
        if(head==null || k==1 || k<=0){
            return null;
        }
        int n=k-1;
        LinkedList curr=head;
        LinkedList prev;
        while(curr!=null){
            n--;
            prev=curr;
            curr=curr.next;
            if(n==0){
                prev.next=curr.next;
                curr=prev.next;
                n=k-1;
            }
        }
        return head;

        /*the optimized way
        if (head == null || k <= 0) {
            return head;
        }

        LinkedList curr = head;
        LinkedList prev = null;
        int count = 1;

        while (curr != null) {
            if (count % k == 0) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
            count++;
        }

        return head;
         */

    }

    public static LinkedList rotateList(LinkedList head, int k) {
        //this is the rwa pointer approach i thought what's happening in memory,it is not the safest or optimized , as it traverses the list 3 times

        if(head==null){
            return null;
        }
        LinkedList curr=head;
        LinkedList prev=null;
        int size = LinkedList.listSize(head);
        int sec=size-k;
        while(sec!=0){
            prev=curr;
            curr=curr.next;
            sec--;
        }
        prev.next=null;
        LinkedList temp=curr;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        head=curr;
        return head;
        //the optimized approach

        /*
        public static LinkedList rotateList(LinkedList head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }

            LinkedList tail = head;
            int size = 1;
            while (tail.next != null) {
                tail = tail.next;
                size++;
            }

            k = k % size;
            if (k == 0) return head; // No rotation needed after modulo

            tail.next = head;

            int stepsToNewTail = size - k;
            LinkedList newTail = tail; // Start from old tail to loop back to head
            while (stepsToNewTail > 0) {
                newTail = newTail.next;
                stepsToNewTail--;
            }

            LinkedList newHead = newTail.next;
            newTail.next = null;

            return newHead;
        }
         */

    }

    public static LinkedList removeDuplicates(LinkedList head) {
        if(head==null || head.next==null){
            return head;
        }
        LinkedList curr=head.next;
        LinkedList prev=head;
        while(curr!=null){
            if(curr.data==prev.data){
                prev.next=curr.next;
                curr=curr.next;
            }
            else {
                prev=curr;
                curr=curr.next;
            }
        }
        return head;
    }

    public static LinkedList mergeSortedList(LinkedList head1,LinkedList head2){
        if(head1==null || head2==null){
            return head1;
        }
        LinkedList dummy = new LinkedList(0);
        LinkedList curr=dummy;
        while (head1!=null && head2!=null){
            if(head1.data<=head2.data){
                curr.next=head1;
                head1=head1.next;
            }else {
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;
        }
        if (head1 != null) {
            curr.next = head1;
        } else {
            curr.next = head2;
        }
        return dummy.next;
    }

    public static LinkedList removeElements(LinkedList head, int val) {
        if(head==null || (head.next==null && head.data==val)){
            return null;
        }
        while(head.data==val){
            head=head.next;
        }
        LinkedList curr=head;
        LinkedList prev=null;
        while(curr!=null){
            if(curr.data==val){
                prev.next=curr.next;
            }
            else {
                prev=curr;
            }
            curr=curr.next;
        }
        return head;
    }

    public static boolean checkPalindrome(LinkedList head) {
        if (head == null || head.next == null) return true;

        LinkedList slow = head;
        LinkedList fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedList prev = null;
        LinkedList curr = slow;
        while (curr != null) {
            LinkedList nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        LinkedList firstHalf = head;
        LinkedList secondHalf = prev;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    //below are some implementation of some dsa question

    public static boolean detectLoop(LinkedList head) {
        if (head == null || head.next == null) return false;
        /*
        the commented approach has a time complexity of BigOh(n2)
        ArrayList<LinkedList> list=new ArrayList<LinkedList>();
        LinkedList curr=head;
        while (curr!=null){
            if(checkVisited(curr,list)){
                return true;
            }
            list.add(curr);
            curr=curr.next;
        }
        return false;

         */

        //the below approach reduces the time complexity to BIgOh(n) by using hashmap for faster check if a node is visited

        HashMap<LinkedList, Boolean> map = new HashMap<>();
        LinkedList curr = head;
        while (curr != null) {
            if(map.getOrDefault(curr, false)) {
                return true;
            }
            map.put(curr,true);
            curr = curr.next;
        }
        return false;
    }
/*
    public static boolean checkVisited(LinkedList cPtr,ArrayList<LinkedList> list){
        for (LinkedList curr : list) {
            if (curr== cPtr) {
                return true;
            }
        }
        return false;
    }

 */

    //another approach to solve it at space complexity of 1 is using slow fast pointer approach

    public static boolean detectLoop2(LinkedList head) {
        if (head == null || head.next == null) return false;
        LinkedList slow = head;
        LinkedList fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static int findLoopLength(LinkedList head) {
        if (head == null || head.next == null) return 0;
        LinkedList slow = head;
        LinkedList fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        int length = 1;
        while (slow != fast) {
            slow = slow.next;
            length++;
        }
        return length;
    }

    public static LinkedList addTwoLLNUM(LinkedList head1, LinkedList head2) {
        if(head1 == null){
            return head2;
        }
        else if(head2==null){
            return head1;
        }
        LinkedList ans = null;
        head1 = LinkedList.reverseLinkedList(head1);
        head2 = LinkedList.reverseLinkedList(head2);
        int sum=0,carry=0,csum=0;
        while(head1!=null&&head2!=null){
            csum=head1.data+head2.data+carry;
            carry=csum/10;
            sum=csum%10;
            head1=head1.next;
            head2=head2.next;
            ans=LinkedList.addFirst(ans,sum);
        }
        while(head1!=null){
            csum=head1.data+carry;
            carry=csum/10;
            sum=csum%10;
            head1=head1.next;
            ans=LinkedList.addFirst(ans,sum);
        }
        while(head2!=null){
            csum=head2.data+carry;
            carry=csum/10;
            sum=csum%10;
            head2=head2.next;
            ans=LinkedList.addFirst(ans,sum);
        }
        if(carry!=0){
            ans=LinkedList.addFirst(ans,carry);
        }
        return ans;
    }

    public static LinkedList addTwoLLNUMOptimizzed(LinkedList head1, LinkedList head2) {
        LinkedList ans = null;

        // Reverse lists to align the least significant digits
        head1 = LinkedList.reverseLinkedList(head1);
        head2 = LinkedList.reverseLinkedList(head2);

        int carry = 0;

        // Continue as long as there is a node in EITHER list, OR a carry leftover
        while (head1 != null || head2 != null || carry > 0) {
            // If a list is exhausted, use 0 as the value
            int val1 = (head1 != null) ? head1.data : 0;
            int val2 = (head2 != null) ? head2.data : 0;

            int csum = val1 + val2 + carry;
            carry = csum / 10;
            int sum = csum % 10;

            ans = LinkedList.addFirst(ans, sum);

            // Move to the next nodes if they exist
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        return ans;
    }

    private static LinkedList findKthOrLast(LinkedList curr, int k) {

        while(curr.next!=null && k>0){
            curr=curr.next;
            k--;
        }
        System.out.println("Got it");
        return curr;
    }

    public static LinkedList reverseInKGroup(LinkedList head, int k) {
        if (head == null || head.next == null   ) return head;
        LinkedList dummy = new LinkedList(0);
        dummy.next = head;
        LinkedList grpP=dummy;
        while (grpP.next != null){
            LinkedList kth= findKthOrLast(grpP,k);
            LinkedList grpS=grpP.next;
            LinkedList grpN=kth.next;

            LinkedList prev = grpN;
            LinkedList curr = grpS;

            while (curr != grpN) {
                LinkedList nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            grpP.next = kth;
            grpP=grpS;
        }
        return dummy.next;
    }

    public static LinkedList mergeKSortedList(LinkedList[]arr){
        if(arr==null || arr.length==0) return null;
        if(arr.length==1) return arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i]=mergeSortedList(arr[i-1],arr[i]);
        }
        return arr[arr.length-1];
    }

    public static LinkedList mergeKSortedList2(LinkedList[] arr) {
        if (arr == null || arr.length == 0) return null;
        return divideAndConquer(arr, 0, arr.length - 1);
    }

    private static LinkedList divideAndConquer(LinkedList[] arr, int start, int end) {
        if (start == end) return arr[start];

        int mid = start + (end - start) / 2;
        System.out.println(mid);
        LinkedList left = divideAndConquer(arr, start, mid);
        LinkedList right = divideAndConquer(arr, mid + 1, end);

        return mergeSortedList(left, right);
    }

}
