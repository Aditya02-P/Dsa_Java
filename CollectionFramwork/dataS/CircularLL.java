
    package dataS;

    public class CircularLL {
        int data;
        CircularLL next;
        CircularLL tail;
        public CircularLL(int data)
        {
            this.data=data;
            next=null;
        }
        /*
        public static CircularLL ifNull(int data) {
            CircularLL newHead=new CircularLL(data);
            newHead.next=newHead;
            return newHead;
        }

        public static void display(CircularLL head) {
            if (head==null) {
                System.out.println("The list is empty");
                return;
            }
            CircularLL current = head;
            do{
                System.out.print(head.data+" ");
                current=current.next;
            }while (current!=head);
            System.out.println();
        }

        public static CircularLL addFirst(CircularLL head,int data) {
            if(head==null){
                return ifNull(data);
            }
            CircularLL newNode=new CircularLL(data);
            CircularLL temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            newNode.next=head;
            temp.next=newNode;
            return newNode;
        }

        public static CircularLL addLast(CircularLL head,int data) {
            if(head==null){
              return ifNull(data);
            }
            CircularLL newNode=new CircularLL(data);
            CircularLL temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            newNode.next=head;
            temp.next=newNode;
            return head;
        }
        */
        public static CircularLL arrToCircularLL(int[] arr) {
            if (arr == null || arr.length == 0) return null;
            if (arr.length == 1) {
                CircularLL head = new CircularLL(arr[0]);
                head.next = head;
                return head;
            }

            CircularLL head = new CircularLL(arr[0]);
            CircularLL tail = head;

            // Loop through the entire rest of the array
            for (int i = 1; i < arr.length; i++) {
                CircularLL newNode = new CircularLL(arr[i]);
                tail.next = newNode;
                tail = newNode;
            }

            // Connect the final dot back to the start
            tail.next = head;
            return head;
        }

//        public static CircularLL addFirst(C)




    }
