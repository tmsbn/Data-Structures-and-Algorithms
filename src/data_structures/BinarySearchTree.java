package data_structures;

/**
 * Created by tmsbn on 6/30/16.
 */
public class BinarySearchTree extends BinaryTree {

    public void insert(int number) {

        TreeNode treeNode = new TreeNode(number);
        if (getRoot() == null) {
            setRoot(treeNode);
        } else {
            insert(getRoot(), treeNode);
        }
    }

    public boolean delete(int number) {

        return delete(getRoot(), number) != null;

    }

    private TreeNode delete(TreeNode root, int number) {

        if (root == null)
            return null;

        else if (root.number == number) {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int inorderSuccessorValue = getMinValue(root.right);
                root.number = inorderSuccessorValue;
                root.right = delete(root.right, inorderSuccessorValue);
            }
        } else if (number > root.number) {
            root.right = delete(root.right, number);
        } else if (number < root.number) {
            root.left = delete(root.left, number);
        }

        return root;

    }



    private int getMinValue(TreeNode treeNode) {

        if (treeNode == null) {
            return Integer.MIN_VALUE;
        }

        if (treeNode.left == null) {
            return treeNode.number;
        }

        return getMinValue(treeNode.left);
    }

    public boolean doesNumberExist(int number) {

        return search(getRoot(), number) != null;
    }

    private TreeNode search(TreeNode root, int number) {

        TreeNode result = null;

        if (root == null || root.number == number) {
            return root;
        }

        if (number > root.number) {
            result = search(root.right, number);
        } else if (number < root.number) {
            result = search(root.left, number);
        }
        return result;


    }

    private TreeNode insert(TreeNode root, TreeNode newNode) {

        if (root == null) {
            root = newNode;
        }


        if (newNode.number > root.number) {

            //The return statement connects the new created node to its root. Only significant in the last recursion call
            root.right = insert(root.right, newNode);
        }

        if (newNode.number < root.number) {
            root.left = insert(root.left, newNode);
        }

        return root;

    }

}
