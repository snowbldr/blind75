package me.kmtn.blind75;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode tn(int val) {
        return new TreeNode(val);
    }

    public static TreeNode tn(int val, TreeNode left, TreeNode right) {
        return new TreeNode(val, left, right);
    }
}
