package me.kmtn.blind75;

import java.util.*;

public class Node {
    public int val = 0;
    public List<Node> neighbors = new ArrayList<>();
    public Node(){}
    public Node(int val){
        this.val = val;
    }
    public Node(int val, List<Node> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }

    public void addNeighbors(Node ...neighbor){
        neighbors.addAll(Arrays.asList(neighbor));
    }


    static Node fromAdjList(int[][] adjList){
        Map<Integer, Node> nodes = new HashMap<>();
        for(int i=0; i<adjList.length; i++){
            Node nd = nodes.computeIfAbsent(i + 1, Node::new);
            for(int n : adjList[i]){
                nd.neighbors.add(nodes.computeIfAbsent(n, Node::new));
            }
        }
        return nodes.values().stream().findAny().orElse(null);
    }
}
