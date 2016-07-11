package questions.linked_lists;

import base.DSABase;
import base.ListQuestions;
import data_structures.BinaryTree;

/**
 * Created by tmsbn on 6/16/16.
 */
public class BinaryTreeTest extends ListQuestions implements DSABase {

    @Override
    public void execute() {

        BinaryTree binaryTree = new BinaryTree(BinaryTree.SAMPLE_TREE.SAMPLE1);
        binaryTree.print(BinaryTree.TRAVERSAL.INORDER);

    }
}
