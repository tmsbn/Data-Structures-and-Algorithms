package data_structures;

public class TreeNode {

    enum TYPE {
        LEFT, RIGHT
    }

    TreeNode(int number) {
        this.number = number;
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public TreeNode(int number, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.number = number;
    }


    public int number;
    public TreeNode left;
    public TreeNode right;


}