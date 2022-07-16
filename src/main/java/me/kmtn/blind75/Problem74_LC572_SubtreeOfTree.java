package me.kmtn.blind75;

import java.util.ArrayList;
import java.util.List;

import static me.kmtn.blind75.TreeNode.tn;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/subtree-of-another-tree/
public class Problem74_LC572_SubtreeOfTree {

    static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<TreeNode> foundSubRoots = new ArrayList<>();
        dfs(root, subRoot, foundSubRoots);
        for(TreeNode foundSubRoot : foundSubRoots){
            if(isSameTree(subRoot, foundSubRoot)){
                return true;
            }
        }
        return false;
    }

    static void dfs(TreeNode root, TreeNode target, List<TreeNode> roots){
        if(root == null) return;
        if(root.val == target.val){
            roots.add(root);
        }
        dfs(root.left, target, roots);
        dfs(root.right, target, roots);
    }

    static boolean isSameTree(TreeNode p, TreeNode q){
        if (p != q && (p == null || q == null)) {
            return false;
        }
        if(p == null) return true;

        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        assertThat(isSubtree(tn(1, tn(1), null), tn(1))).isTrue();
        assertThat(isSubtree(tn(3, tn(4, tn(1), tn(2)), tn(5)), tn(4, tn(1), tn(2)))).isTrue();
    }
}
