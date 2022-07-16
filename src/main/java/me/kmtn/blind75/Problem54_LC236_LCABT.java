package me.kmtn.blind75;

import java.util.Stack;

import static me.kmtn.blind75.TreeNode.tn;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class Problem54_LC236_LCABT {

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pPath = new Stack<>();
        findPath(root, p, pPath);
        Stack<TreeNode> qPath = new Stack<>();
        findPath(root, q, qPath);
        TreeNode last = pPath.get(0);
        for (int i = 1; i < pPath.size(); i++) {
            if (qPath.size() < i + 1 || qPath.get(i) != pPath.get(i)) {
                break;
            } else {
                last = pPath.get(i);
            }
        }
        return last;
    }

    static boolean findPath(TreeNode root, TreeNode target, Stack<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root == target) return true;
        if (findPath(root.left, target, path)) return true;
        if (findPath(root.right, target, path)) return true;
        path.pop();
        return false;
    }

    public static void main(String[] args) {
        TreeNode four = tn(4, tn(3), tn(5));
        TreeNode two = tn(2, tn(0), four);
        TreeNode eight = tn(8, tn(7), tn(9));
        TreeNode six = tn(6, two, eight);
        assertThat(lowestCommonAncestor(six, two, four)).isEqualTo(two);
        assertThat(lowestCommonAncestor(six, two, eight)).isEqualTo(six);
    }
}
