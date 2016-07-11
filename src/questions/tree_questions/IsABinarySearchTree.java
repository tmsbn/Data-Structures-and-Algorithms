package questions.tree_questions;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.DSABase;
import base.TreesQuestions;
import data_structures.BinaryTree;

/**
 * Created by tmsbn on 6/18/16.
 */
public class IsABinarySearchTree extends TreesQuestions implements DSABase {

    private BinaryTree binaryTree;

    @Override
    public void execute() {

        binaryTree = new BinaryTree(BinaryTree.SAMPLE_TREE.SAMPLE2);
        binaryTree.print(BinaryTree.TRAVERSAL.LEVELORDER);

        new SwitchMenu(this).show();

    }

    @Strategy
    public void firstMethod() {

        binaryTree.print(BinaryTree.TRAVERSAL.LEVELORDER);
        System.out.println((binaryTree.isBinarySearchTree() ? "Yes, it is a binary search tree" : "Not a binary search tree"));

    }


}
