package data_structures;

public class Node {

    Node(int number) {
        this.number = number;
    }

    public Node(Node next) {
        this.next = next;
    }

    public int number;
    public Node next;

}