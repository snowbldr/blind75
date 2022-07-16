package me.kmtn.blind75;

import java.util.Arrays;

import static me.kmtn.blind75.Problem26_LC100_SameTree.isSameTree;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class Problem29_LC105_ConstructBinaryTreeFromOrders {

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                mid = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid+1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid+1, preorder.length), Arrays.copyOfRange(inorder, mid+1, inorder.length));
        return root;
    }

    static TreeNode tn(int val) {
        return new TreeNode(val);
    }

    static TreeNode tn(int val, TreeNode left, TreeNode right) {
        return new TreeNode(val, left, right);
    }

    public static void main(String[] args) {
//        assertThat(isSameTree(
//                buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}),
//                tn(3, tn(9), tn(20, tn(15), tn(7)))
//        )).isTrue();
        assertThat(isSameTree(
                buildTree(new int[]{25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90}, new int[]{4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90}),
                tn(25,
                        tn(15, tn(10, tn(4), tn(12)), tn(22, tn(18), tn(24))),
                        tn(50, tn(35, tn(31), tn(44)), tn(70, tn(66), tn(90)))
                )
        )).isTrue();
    }
}
