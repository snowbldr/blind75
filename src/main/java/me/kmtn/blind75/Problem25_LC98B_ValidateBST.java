package me.kmtn.blind75;

import java.util.ArrayDeque;
import java.util.Deque;

import static me.kmtn.blind75.TreeNode.tn;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/validate-binary-search-tree/
public class Problem25_LC98B_ValidateBST {

    static boolean isValidBST(TreeNode root) {
        return checkBstRange(root, null, null);
    }

    static boolean checkBstRange(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }
        return checkBstRange(root.left, min, root.val) && checkBstRange(root.right, root.val, max);
    }

    static boolean isValidBST1(TreeNode root) {
        return checkBst1(root, new ArrayDeque<>());
    }

    static boolean checkBst1(TreeNode root, Deque<TreeNode> parents) {
        if(root == null){
            return true;
        }
        TreeNode current = root;
        for(TreeNode parent : parents){
            if(parent.left == current){
                if(root.val >= parent.val){
                    return false;
                }
            } else {
                if(root.val <= parent.val){
                    return false;
                }
            }
            current = parent;
        }
        parents.push(root);
        boolean result = checkBst1(root.left, parents) && checkBst1(root.right, parents);
        parents.pop();
        return result;
    }


    public static void main(String[] args) {
        assertThat(isValidBST(tn(5, tn(4, null, null), tn(6, tn(3), tn(7))))).isFalse();
        assertThat(isValidBST(tn(Integer.MIN_VALUE, null, tn(Integer.MAX_VALUE)))).isTrue();
        assertThat(isValidBST(tn(2, tn(1), tn(3)))).isTrue();
        assertThat(isValidBST(tn(2, tn(3), tn(3)))).isFalse();
        assertThat(isValidBST(tn(2, tn(1), tn(1)))).isFalse();
    }
}
