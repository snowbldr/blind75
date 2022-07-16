package me.kmtn.blind75;

import static me.kmtn.blind75.TreeNode.tn;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/same-tree/
public class Problem26_LC100_SameTree {

    static boolean isSameTree(TreeNode p, TreeNode q) {
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
        assertThat(isSameTree(tn(2, tn(1), tn(3)), tn(2, tn(1), tn(3)))).isTrue();
        assertThat(isSameTree(tn(2, tn(1), tn(3)), tn(2, tn(2), tn(3)))).isFalse();
        assertThat(isSameTree(tn(2, tn(1), tn(3)), tn(2, null, tn(3)))).isFalse();
        assertThat(isSameTree(tn(5, tn(4, null, null), tn(6, tn(3), tn(7))), tn(5, tn(4, null, null), tn(6, tn(3), tn(7))))).isTrue();
    }
}
