package data_structures;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by tmsbn on 6/16/16.
 */
public class BinaryTree {

    private TreeNode root;

    public enum TRAVERSAL {
        PREORDER, POSTORDER, INORDER, LEVELORDER
    }

    public enum SAMPLE_TREE {
        SAMPLE1, SAMPLE2, SAMPLE3, SAMPLE4
    }

    public enum SIDE {
        LEFT, RIGHT, ALL
    }

    public BinaryTree() {

    }

    public BinaryTree(@NotNull TreeNode root) {
        this.root = root;
    }

    public BinaryTree(@NotNull SAMPLE_TREE sampleTree) {

        switch (sampleTree) {

            case SAMPLE1:
                this.root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(7));
                break;
            case SAMPLE2:
                this.root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
                break;
            case SAMPLE3:
                this.root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(7, new TreeNode(6), new TreeNode(8)));
                break;
            case SAMPLE4:
                this.root = new TreeNode(5, new TreeNode(3, new TreeNode(1), new TreeNode(4)), new TreeNode(7, new TreeNode(6), new TreeNode(8)));
                break;
        }
    }


    public void print(TRAVERSAL traversal) {

        switch (traversal) {

            case PREORDER:
                preOrderTraversal(root);
                break;

            case POSTORDER:
                postOrderTraversal(root);
                break;

            case INORDER:

                inorderTraversal(root);
                break;

            case LEVELORDER:

                levelOrder();
                break;
        }

    }

    private void levelOrder() {

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            TreeNode node = nodes.removeFirst();
            System.out.print(node.number + " ");

            if (node.left != null)
                nodes.add(node.left);

            if (node.right != null)
                nodes.add(node.right);
        }


    }

    public void convertToDoublyLinkedList() {

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        TreeNode present = null, previous = null;

        while (!linkedList.isEmpty()) {

            TreeNode node = linkedList.removeFirst();

            if (node.left != null)
                linkedList.add(node.left);

            if (node.right != null)
                linkedList.add(node.right);

            node.left = previous;
            node.right = linkedList.peekFirst();

            previous = linkedList.peekFirst();


        }
    }

    public void printAllPathsToLeaf() {

        pathToLeaf(root, new ArrayList<Integer>());
    }

    private void pathToLeaf(TreeNode treeNode, ArrayList<Integer> path) {

        path.add(treeNode.number);
        if (treeNode.left == null && treeNode.right == null) {
            printList(path);
            return;
        }


        if (treeNode.left != null)
            pathToLeaf(treeNode.left, path);

        path.remove(path.size() - 1);

        if (treeNode.right != null)
            pathToLeaf(treeNode.right, path);

        path.remove(path.size() - 1);

    }

    private void printList(ArrayList<Integer> path) {

        boolean isComma = false;
        for (Integer node : path) {

            if (isComma) {
                System.out.print(">");
            }

            System.out.print(node);
            isComma = true;
        }
        System.out.println();
    }


    private void preOrderTraversal(TreeNode node) {

        if (node != null) {

            System.out.print(node.number + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }

    }

    private void postOrderTraversal(TreeNode node) {

        if (node != null) {

            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.number + " ");
        }

    }

    private void inorderTraversal(TreeNode node) {

        if (node != null) {

            inorderTraversal(node.left);
            System.out.print(node.number + " ");
            inorderTraversal(node.right);
        }

    }

    public boolean isBinarySearchTree() {

        return isBinarySearchTree(getRoot());
    }

    private boolean isBinarySearchTree(TreeNode treeNode) {


        if (treeNode == null)
            return true;
        else
            return isSubtreeGreater(treeNode.right, treeNode.number) && isSubtreeLesser(treeNode.left, treeNode.number) && isBinarySearchTree(treeNode.left) && isBinarySearchTree(treeNode.right);
    }

    private boolean isSubtreeLesser(TreeNode treeNode, int number) {

        if (treeNode == null) {
            return true;
        }

        if (treeNode.number < number)
            return isSubtreeLesser(treeNode.left, number) && isSubtreeLesser(treeNode.right, number);
        else
            return false;
    }

    private boolean isSubtreeGreater(TreeNode treeNode, int number) {

        if (treeNode == null) {
            return true;
        }

        if (treeNode.number > number)
            return isSubtreeGreater(treeNode.left, number) && isSubtreeGreater(treeNode.right, number);
        else
            return false;
    }

    public int getMaxDepth() {
        return maxDepthOfSubtree(root);
    }

    public int getMinDepth() {
        return minDepthOfSubtree(root);
    }

    private int maxDepthOfSubtree(TreeNode node) {


        int left = node.left != null ? maxDepthOfSubtree(node.left) : 0;
        int right = node.right != null ? maxDepthOfSubtree(node.right) : 0;

        return 1 + Math.max(left, right);
    }

    private int minDepthOfSubtree(TreeNode node) {

        if (node.left == null && node.right == null)
            return 1;

        int left = node.left != null ? minDepthOfSubtree(node.left) : Integer.MAX_VALUE;
        int right = node.right != null ? minDepthOfSubtree(node.right) : Integer.MAX_VALUE;

        return 1 + Math.min(left, right);
    }

    public int getSumOfAllLeafNodes(SIDE side) {

        return sumOfLeafNodes(root, 0, side);

    }

    private int sumOfLeafNodes(TreeNode node, int sum, SIDE side) {


        switch (side) {
            case ALL:
                if (isLeafNode(node)) {
                    sum += node.number;
                    return sum;
                }
                break;
            case LEFT:
                if (isLeafNode(node.left)) {
                    sum += node.left.number;
                    return sum;
                }
                break;
            case RIGHT:
                if (isLeafNode(node.right)) {
                    sum += node.right.number;
                    return sum;
                }
                break;
        }

        if (node.left != null)
            sum = sumOfLeafNodes(node.left, sum, side);

        if (node.right != null)
            sum = sumOfLeafNodes(node.right, sum, side);

        return sum;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }


}
