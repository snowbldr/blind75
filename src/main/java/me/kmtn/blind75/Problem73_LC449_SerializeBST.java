package me.kmtn.blind75;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import static me.kmtn.blind75.Problem26_LC100_SameTree.isSameTree;
import static me.kmtn.blind75.TreeNode.tn;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/serialize-and-deserialize-bst/
public class Problem73_LC449_SerializeBST {
    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "";
            if(root.left == null && root.right== null) return String.valueOf(root.val);
            StringBuilder sb = new StringBuilder();

            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            TreeNode curr;
            while (!q.isEmpty()) {
                curr = q.poll();

                if (curr.left != null) {
                    q.add(curr.left);
                    sb.append(curr.val).append("L:").append(curr.left.val).append(",");
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    sb.append(curr.val).append("R:").append(curr.right.val).append(",");
                }
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Map<Integer, TreeNode> nodes = new HashMap<>();
            StringBuilder parent = new StringBuilder();
            StringBuilder child = new StringBuilder();
            boolean isRight = false;
            boolean isParent = true;
            TreeNode root = null;
            for (char c : data.toCharArray()) {
                switch (c) {
                    case 'R':
                        isRight = true;
                        break;
                    case 'L':
                        isRight = false;
                        break;
                    case ':':
                        isParent = false;
                        break;
                    case ',':
                        isParent = true;
                        int parentVal = Integer.parseInt(parent.toString());
                        int childVal = Integer.parseInt(child.toString());
                        parent = new StringBuilder();
                        child = new StringBuilder();
                        TreeNode n;
                        if (nodes.size() == 0) {
                            root = new TreeNode(parentVal);
                            nodes.put(parentVal, root);
                            n = root;
                        } else {
                            n = nodes.computeIfAbsent(parentVal, k -> new TreeNode(parentVal));
                        }
                        if (isRight) {
                            n.right = nodes.computeIfAbsent(childVal, k -> new TreeNode(childVal));
                        } else {
                            n.left = nodes.computeIfAbsent(childVal, k -> new TreeNode(childVal));
                        }
                        break;
                    default:
                        if (isParent) {
                            parent.append(c);
                        } else {
                            child.append(c);
                        }
                }
            }
            if(root == null && parent.length()>0){
                root = new TreeNode(Integer.parseInt(parent.toString()));
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Codec c = new Codec();
        assertThat(isSameTree(tn(0), c.deserialize(c.serialize(tn(0))))).isTrue();
        TreeNode root = tn(25, tn(20, tn(10, tn(5, tn(-1), tn(8)), tn(12, null, tn(15))), tn(22)), tn(36, tn(30, tn(28), null), tn(40, tn(38), tn(48, tn(45), tn(50)))));
        String serialized = c.serialize(root);
        assertThat(isSameTree(root, c.deserialize(serialized))).isTrue();
    }
}
