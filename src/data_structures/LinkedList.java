package data_structures;

import utils.StringUtils;

public class LinkedList {

    private Node head, tail;
    boolean isLoop = false;

    public void insert(int number) {

        Node node = new Node(number);
        insert(node);

    }

    public void insert(int... numbers) {

        for (int number : numbers) {
            Node node = new Node(number);
            insert(node);
        }
    }

    public void insert(Node node) {

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void makeLoop(int index) {

        if (index >= getSize()) {
            throw new IndexOutOfBoundsException("Cannot make a loop");
        } else {

            Node temp = head;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
            tail.next = temp;
        }
        isLoop = true;
    }

    public int getSize() {

        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    public LinkedList merge(LinkedList linkedList) {

        LinkedList mergedLinkedList = new LinkedList();

        Node temp1 = this.head;
        Node temp2 = linkedList.head;

        while (temp1 != null && temp2 != null) {

            if (temp1.number > temp2.number) {

                mergedLinkedList.insert(temp2.number);
                temp2 = temp2.next;

            } else {

                mergedLinkedList.insert(temp1.number);
                temp1 = temp1.next;
            }
        }

        if (temp1 != null) {
            mergedLinkedList.tail.next = temp1;
            mergedLinkedList.tail = this.tail;
        } else {
            mergedLinkedList.tail.next = temp2;
            mergedLinkedList.tail = linkedList.tail;
        }


//            while (temp2 != null) {
//                mergedLinkedList.insert(temp2.number);
//                temp2 = temp2.next;
//            }
//
//            while (temp1 != null) {
//                mergedLinkedList.insert(temp1.number);
//                temp1 = temp1.next;
//            }

        return mergedLinkedList;

    }

    public void printList() {

        System.out.print(StringUtils.lineSeparator);
        Node temp = head;

        boolean separator = false;
        while (true) {

            if (separator) {
                System.out.print(">");
            }

            System.out.print(temp.number);

            if (temp == tail) {
                break;
            }

            temp = temp.next;
            separator = true;
        }
    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }


}