package questions.linked_lists;

import base.DSABase;
import base.ListQuestions;
import data_structures.DoublyLinkedList;

/**
 * Created by tmsbn on 6/20/16.
 */
public class LRUCache extends ListQuestions implements DSABase {

    @Override
    public void execute() {

        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.accessPage(10);

        linkedList.accessPage(11);

        linkedList.accessPage(12);

        linkedList.accessPage(13);

        linkedList.accessPage(14);

        linkedList.accessPage(16);

        linkedList.accessPage(11);

        linkedList.accessPage(17);

        linkedList.accessPage(14);


    }
}
