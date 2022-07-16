package me.kmtn.blind75;

import java.util.ArrayList;
import java.util.List;

import static me.kmtn.blind75.TreeNode.tn;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class Problem52_LC230_kthSmallestElementBST {

    static int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        dfs(root, k, result);
        return result.get(result.size() - 1);
    }

    static void dfs(TreeNode root, int k, List<Integer> result) {
        if (result.size() == k) {
            return;
        }
        if (root == null) {
            return;
        }
        dfs(root.left, k, result);
        if (result.size() == k) {
            return;
        }
        result.add(root.val);
        if (result.size() == k) {
            return;
        }
        dfs(root.right, k, result);
    }

    public static void main(String[] args) {
        assertThat(kthSmallest(tn(3, tn(1, null, tn(2)), tn(4)), 1)).isEqualTo(1);
    }
}
