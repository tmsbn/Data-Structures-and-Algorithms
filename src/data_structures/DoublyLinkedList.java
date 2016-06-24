package data_structures;

import java.util.HashMap;

/**
 * Created by tmsbn on 6/19/16.
 */
public class DoublyLinkedList {

    public Node head = null, tail = null;
    public HashMap<Integer, Node> hashMap = new HashMap<>();
    private int cacheSize = 4;
    private int currentSize = 0;

    public void addToList(int number) {

        addToList(new Node(number));

    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }


    private void addToList(Node node) {

        hashMap.put(node.number, node);

        if (head == null) {

            head = node;
            tail = node;
            node.next = null;
            node.previous = null;
            currentSize++;


        } else {

            if (currentSize > cacheSize - 1) {

                hashMap.remove(tail.number);
                tail = tail.previous;
                tail.next = null;


            } else {
                currentSize++;
            }

            head.previous = node;
            node.next = head;
            node.previous = null;
            head = node;
        }

    }

    public void accessPage(int number) {

        Node node = hashMap.get(number);

        if (node != null) {

            bringToFront(node);
        } else {
            addToList(number);
        }
        print();
    }

    public void print() {

        Node temp = head;
        while (temp != null) {

            if (temp != head)
                System.out.print(" > ");

            System.out.print((temp.number));
            temp = temp.next;
        }
        System.out.println();
    }

    private void bringToFront(Node node) {


        Node prev = node.previous;
        Node next = node.next;


        if (next != null) {

            prev.next = next;
            next.previous = prev;

        } else {

            prev.next = null;
            tail = prev;
        }

        node.next = head;
        node.previous = null;

        head.previous = node;
        head = node;

    }
}
