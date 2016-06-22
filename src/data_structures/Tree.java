package data_structures;

import com.sun.istack.internal.NotNull;

import java.util.LinkedList;

/**
 * Created by tmsbn on 6/16/16.
 */
public class Tree {

    private TreeNode root;

    public enum TRAVERSAL {
        PREORDER, POSTORDER, INORDER, LEVELORDER
    }

    public enum TREES{
        SAMPLE1, SAMPLE2, SAMPLE3
    }

    public Tree(@NotNull Node root){

    }

    public Tree(@NotNull TREES trees){

        switch (trees){

            case SAMPLE1:
                this.root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5));
                break;
            case SAMPLE2:
                this.root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
                break;
            case SAMPLE3:
                this.root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(7, new TreeNode(6), new TreeNode(8)));
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
            node.right = linkedList.peekFirst();;

            previous = linkedList.peekFirst();


        }
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

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }


}
