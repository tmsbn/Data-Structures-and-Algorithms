package questions.linked_lists;

import base.DSABase;
import base.ListQuestions;
import data_structures.BinaryTree;
import data_structures.TreeNode;

/**
 * Created by tmsbn on 6/17/16.
 */
public class TreeToDoubleList extends ListQuestions implements DSABase {

    @Override
    public void execute() {

        BinaryTree binaryTree = new BinaryTree(BinaryTree.SAMPLE_TREE.SAMPLE2);
        binaryTree.convertToDoublyLinkedList();

        TreeNode temp = binaryTree.getRoot();
        while (temp != null) {
            System.out.print(temp.number + " ");
            temp = temp.right;
        }
    }
}
