package me.kmtn.blind75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static me.kmtn.blind75.Util.twoDIntArrayFromString;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/clone-graph/
public class Problem34_LC133_CloneGraph {

    static Node cloneGraph(Node node) {
        if(node == null) return null;
        return doClone(node, new HashMap<>());
    }

    static Node doClone(Node node, Map<Integer, Node> visited) {
        if(visited.containsKey(node.val)){
            return visited.get(node.val);
        }
        Node clone = new Node(node.val);
        visited.put(node.val, clone);
        for(Node neighbor: node.neighbors){
            clone.neighbors.add(doClone(neighbor, visited));
        }
        return clone;
    }

    static boolean isClone(Node n1, Node n2, Set<Node> visited) {
        if(visited.contains(n1) || visited.contains(n2)){
            return true;
        }
        visited.add(n1);
        visited.add(n2);
        if (n1.val != n2.val || n1 == n2) {
            return false;
        }
        if (n1.neighbors.size() != n2.neighbors.size()) {
            return false;
        }
        if(visited.contains(n1) ){
            return true;
        }
        for (int i = 0; i < n1.neighbors.size(); i++) {
            Node a1 = n1.neighbors.get(i);
            Node a2 = n2.neighbors.get(i);
            if (!isClone(a1, a2, visited)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] adjList = twoDIntArrayFromString("[[2,4],[1,3],[2,4],[1,3]]");
        Node graph = Node.fromAdjList(adjList);
        assertThat(isClone(graph, cloneGraph(graph), new HashSet<>())).isTrue();
    }
}
