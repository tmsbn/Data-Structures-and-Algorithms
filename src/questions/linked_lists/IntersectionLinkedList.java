package questions.linked_lists;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.DSABase;
import base.ListQuestions;
import data_structures.LinkedList;
import data_structures.Node;

import java.util.HashSet;

/**
 * Created by tmsbn on 6/12/16.
 */
public class IntersectionLinkedList extends ListQuestions implements DSABase {

    LinkedList list1, list2;

    @Override
    public void execute() {

        list1 = new LinkedList();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(19);

        list2 = new LinkedList();
        list2.insert(10);
        list2.insert(12);
        list2.insert(13);
        list2.insert(19);


        for (int i = 20; i < 25; i++) {
            Node node = new Node(i);
            list1.insert(node);
            list2.insert(node);
        }

        list1.printList();
        list2.printList();

        new SwitchMenu(this).show();


    }

    @Strategy
    public void hashSetMethod() {

        HashSet<Node> hashSet = new HashSet<>();
        Node temp1 = list1.getHead();

        while (temp1 != null) {
            hashSet.add(temp1);
            temp1 = temp1.next;
        }

        Node temp2 = list2.getHead();
        while (temp2 != null) {
            if (hashSet.contains(temp2)) {
                System.out.println("The intersection is at the point " + temp2.number);
                return;
            }
            temp2 = temp2.next;
        }
        System.out.println("There are no intersections");


    }

    @Strategy
    public void naiveMethod() {

        Node temp1 = list1.getHead();
        while (temp1 != null) {
            Node temp2 = list2.getHead();
            while (temp2 != null) {

                if (temp1 == temp2) {
                    System.out.println("The intersection is at the point " + temp2.number);
                    return;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        System.out.println("There are no intersections");

    }


}
