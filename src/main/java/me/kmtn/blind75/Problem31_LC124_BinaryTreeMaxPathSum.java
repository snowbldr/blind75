package me.kmtn.blind75;

import static me.kmtn.blind75.TreeNode.tn;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class Problem31_LC124_BinaryTreeMaxPathSum {

    static int max = 0;
    static int maxPathSum(TreeNode root) {
        max = root.val;
        findMax(root);
        return max;
    }

    static int findMax(TreeNode root){
        if(root == null) return 0;
        int leftMax = Math.max(findMax(root.left), 0);
        int rightMax = Math.max(findMax(root.right), 0);

        max = Math.max(max, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }


    public static void main(String[] args) {
        assertThat(maxPathSum(tn(1, tn(2), tn(3)))).isEqualTo(6);
    }
}
