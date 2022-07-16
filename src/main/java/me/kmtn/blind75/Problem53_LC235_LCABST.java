package me.kmtn.blind75;

import java.util.ArrayList;
import java.util.List;

import static me.kmtn.blind75.TreeNode.tn;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class Problem53_LC235_LCABST {

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        findPath(root, p, pPath);
        List<TreeNode> qPath = new ArrayList<>();
        findPath(root, q, qPath);
        TreeNode last = pPath.get(0);
        for(int i=1; i<pPath.size(); i++){
            if(qPath.size() < i+1 || qPath.get(i) != pPath.get(i)){
                break;
            } else {
                last = pPath.get(i);
            }
        }
        return last;
    }

    static void findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        path.add(root);
        if(root != target){
            findPath(target.val > root.val ? root.right : root.left, target, path);
        }
    }

    public static void main(String[] args) {
        TreeNode four = tn(4, tn(3), tn(5));
        TreeNode two = tn(2, tn(0), four);
        TreeNode eight = tn(8, tn(7), tn(9));
        TreeNode six = tn(6, two, eight);
        assertThat(lowestCommonAncestor(six, two, eight)).isEqualTo(six);
        assertThat(lowestCommonAncestor(six, two, four)).isEqualTo(two);
    }
}
