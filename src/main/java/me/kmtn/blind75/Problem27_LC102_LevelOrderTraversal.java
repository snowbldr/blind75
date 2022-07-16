package me.kmtn.blind75;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static java.util.List.of;
import static me.kmtn.blind75.TreeNode.tn;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class Problem27_LC102_LevelOrderTraversal {

    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level_size = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            for (int i = 0; i < level_size; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelValues);
        }
        return result;
    }

    public static void main(String[] args) {
        assertThat(levelOrder(tn(2, tn(1), tn(3)))).isEqualTo(of(of(2), of(1, 3)));
        assertThat(levelOrder(tn(3, tn(9), tn(20, tn(15), tn(7))))).isEqualTo(of(of(3), of(9, 20), of(15, 7)));
    }
}
