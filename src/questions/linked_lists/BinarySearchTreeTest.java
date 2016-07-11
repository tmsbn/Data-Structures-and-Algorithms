package questions.linked_lists;

import base.DSABase;
import base.ListQuestions;
import data_structures.BinarySearchTree;
import data_structures.BinaryTree;

/**
 * Created by tmsbn on 6/16/16.
 */
public class BinarySearchTreeTest extends ListQuestions implements DSABase {

    @Override
    public void execute() {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
        binarySearchTree.insert(1);
        binarySearchTree.insert(5);

        binarySearchTree.print(BinaryTree.TRAVERSAL.LEVELORDER);

//        int number = InputUtils.getIntFromUser("Enter a number to delete");
//        System.out.println((binarySearchTree.delete(number) ? "Deleted" : "Cannot find number"));
//
//        binarySearchTree.print(BinaryTree.TRAVERSAL.LEVELORDER);

        System.out.println((binarySearchTree.isBinarySearchTree() ? "Yes, it is a binary search tree" : "Not a binary search tree"));


//        int number = InputUtils.getIntFromUser("Enter a number to search");
//
//        System.out.println((binarySearchTree.doesNumberExist(number) ? "Yes, it exists" : "Cannot find number"));
//

    }
}
