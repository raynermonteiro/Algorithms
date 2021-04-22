package common.node;

public class LinkedList {

    Node head; //Head of list
    public LinkedList (){
        head = null;
    }

    /**
     * @return the head node of this list
     */
    public Node getHead(){
        return this.head;
    }
    /**
     * The node class
     */
    public static class Node {
        int data;
        Node next;

        /**
         * Insert data
         * @param data to be inserted
         */
        Node(int data){
            this.data = data;
            next = null;
        }

        public int getData(){
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    /**
     * Insert Data into linked list
     * @param list the LinkedList that data needs to be inserted into
     * @param data the element that needs to be inserted
     * @return return the LinkedList with data inserted
     */
    public static LinkedList insert(LinkedList list, int data) {
        //Create New Node
        Node newNode = new Node(data);
        /*
         * check if head is null, if so then this is the head node
         */
        if(list.head == null){
            list.head = newNode;
        } else {
            Node lastNode = list.head;
            while(lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        return list;
    }

    /**
     * Prints the current list
     * @param list the linked list to be printed
     */
    public static void printList(LinkedList list) {
        if(list.head == null){
            System.out.println("Linked List is empty");
            return;
        }
        Node currNode = list.head;
        System.out.print("LinkedList:");
        while (currNode != null) {
            System.out.print(currNode.data+" ");
            currNode = currNode.next;
        }
    }
}
