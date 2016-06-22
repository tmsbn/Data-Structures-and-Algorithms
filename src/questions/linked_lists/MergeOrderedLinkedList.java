package questions.linked_lists;

import base.DSABase;
import base.ListQuestions;
import utils.StringUtils;

/**
 * Created by tmsbn on 6/11/16.
 */
public class MergeOrderedLinkedList extends ListQuestions implements DSABase {

    @Override
    public void execute() {

        LinkedList linkedList1 = new LinkedList();
        linkedList1.insert(0);
        linkedList1.insert(1);
        linkedList1.insert(2);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insert(10);
        linkedList2.insert(11);
        linkedList2.insert(12);

        linkedList1.printList();
        linkedList2.printList();

    }


    private class LinkedList {

        Node head, tail;

        void insert(int number) {

            Node node = new Node(number);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }

        }

        void merge(LinkedList linkedList) {

        }

        void printList() {

            System.out.print(StringUtils.lineSeparator);
            Node temp = head;

            boolean separator = false;
            while (temp != null) {

                if (separator) {
                    System.out.print(">");
                }

                System.out.print(temp.number);

                temp = temp.next;
                separator = true;
            }
        }

        private class Node {

            Node(int number) {
                this.number = number;
            }

            private int number;
            private Node next;

        }
    }


}
