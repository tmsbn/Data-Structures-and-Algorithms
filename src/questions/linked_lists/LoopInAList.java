package questions.linked_lists;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.DSABase;
import base.ListQuestions;
import data_structures.LinkedList;
import data_structures.Node;

/**
 * Created by tmsbn on 6/14/16.
 */
public class LoopInAList extends ListQuestions implements DSABase {

    private LinkedList linkedList = new LinkedList();

    @Override
    public void execute() {

        linkedList.insert(3, 2, 9, 4, 1, 10, 4, 5);
        linkedList.makeLoop(4);
        linkedList.printList();

        new SwitchMenu(this).show();
    }

    @Strategy
    public void naiveAlgorithm() {

        Node temp1 = linkedList.getHead();
        temp1 = temp1.next;

        while (temp1 != null) {

            Node temp2 = linkedList.getHead();
            while (temp2 != temp1) {

                if (temp1.next == temp2) {
                    System.out.println("The start of the loop is " + temp2.number);
                    return;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        System.out.println("Could not find a loop");

    }

    @Strategy
    public void FloydsLoopDetectionAlgorithm() {

        Node slow = linkedList.getHead();
        Node fast = linkedList.getHead();

        while (fast != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {

                fast = linkedList.getHead();

                while (fast != slow) {

                    fast = fast.next;
                    slow = slow.next;
                }
                System.out.println("The start of the loop is at " + fast.number);
                break;
            }

        }


    }
}
