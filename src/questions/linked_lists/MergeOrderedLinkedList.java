package questions.linked_lists;

import base.DSABase;
import base.ListQuestions;
import data_structures.LinkedList;

/**
 * Created by tmsbn on 6/11/16.
 */
public class MergeOrderedLinkedList extends ListQuestions implements DSABase {

    @Override
    public void execute() {

        LinkedList linkedList1 = new LinkedList();
        linkedList1.insert(0);
        linkedList1.insert(5);
        linkedList1.insert(7);
        linkedList1.insert(10);
        linkedList1.insert(13);
        linkedList1.insert(15);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insert(2);
        linkedList2.insert(3);
        linkedList2.insert(8);

        linkedList1.printList();
        linkedList2.printList();

        LinkedList mergedList = linkedList1.merge(linkedList2);
        mergedList.printList();

    }


}
