package me.kmtn.blind75;

import static me.kmtn.blind75.TreeNode.tn;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class Problem28_LC104_MaxDepthBinaryTree {

    static int maxDepth(TreeNode root) {
        return findMaxDepth(root, 0);
    }

    static int findMaxDepth(TreeNode root, int currentDepth) {
        if(root == null) {
            return currentDepth;
        }
        return Math.max(findMaxDepth(root.left, currentDepth+1), findMaxDepth(root.right, currentDepth+1));
    }

    public static void main(String[] args) {
        assertThat(maxDepth(tn(1, tn(2), tn(3)))).isEqualTo(2);
    }
}
