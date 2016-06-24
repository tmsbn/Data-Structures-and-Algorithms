package questions.linked_lists;

import base.DSABase;
import base.ListQuestions;
import data_structures.Tree;
import data_structures.TreeNode;

/**
 * Created by tmsbn on 6/17/16.
 */
public class TreeToDoubleList extends ListQuestions implements DSABase {

    @Override
    public void execute() {

        Tree tree = new Tree(Tree.TREES.SAMPLE2);
        tree.convertToDoublyLinkedList();

        TreeNode temp = tree.getRoot();
        while (temp != null) {
            System.out.print(temp.number + " ");
            temp = temp.right;
        }
    }
}
