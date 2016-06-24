package questions.tree_questions;

import base.DSABase;
import base.TreesQuestions;
import data_structures.Tree;
import data_structures.TreeNode;

/**
 * Created by tmsbn on 6/18/16.
 */
public class IsABinarySearchTree extends TreesQuestions implements DSABase {

    @Override
    public void execute() {

        Tree tree = new Tree(Tree.TREES.SAMPLE3);
        if(isBinarySearchTree(tree.getRoot())){
            System.out.print("Its a binary search tree");
        }else{
            System.out.print("Its not a binary search tree");
        }


    }

    private boolean isBinarySearchTree(TreeNode node) {

        if (node == null)
            return true;

        if (node.left != null) {

            if (node.left.number > node.number) {
                return false;
            }
        }

        if (node.right != null) {

            if (node.right.number < node.number) {
                return false;
            }
        }

        if (!isBinarySearchTree(node.left) || !isBinarySearchTree(node.right)) {
            return false;
        }

        return true;

    }


}
