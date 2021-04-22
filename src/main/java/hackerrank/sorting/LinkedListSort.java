package hackerrank.sorting;
import common.node.LinkedList;

import java.util.Comparator;


public class LinkedListSort {
    public LinkedList sortList(LinkedList list) {
        LinkedList.Node currNode = list.getHead();
        while (currNode.getNext() != null) {
            LinkedList.Node nextNode = currNode.getNext();
            if(currNode.getData() > nextNode.getData()){
            }
        }
        return list;
    }
    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        LinkedList.insert(list, 19);
        LinkedList.insert(list, 15);
        LinkedList.insert(list, 1);
        LinkedList.insert(list, 4);
        LinkedList.insert(list, 2);
        LinkedList.insert(list, 3);
        LinkedList.insert(list, 7);

        LinkedList.printList(list);
    }
}
