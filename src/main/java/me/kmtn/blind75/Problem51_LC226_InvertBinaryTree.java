package me.kmtn.blind75;

import static me.kmtn.blind75.Problem26_LC100_SameTree.isSameTree;
import static me.kmtn.blind75.TreeNode.tn;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/invert-binary-tree/
public class Problem51_LC226_InvertBinaryTree {

    static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode orig = tn(4, tn(2, tn(1), tn(3)), tn(7, tn(6), tn(9)));
        TreeNode inverted = tn(4, tn(7,tn(9), tn(6)), tn(2, tn(3), tn(1)));
        assertThat(isSameTree(invertTree(orig), inverted)).isTrue();
    }
}
