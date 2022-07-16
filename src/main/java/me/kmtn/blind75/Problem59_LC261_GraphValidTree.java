package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/graph-valid-tree/
public class Problem59_LC261_GraphValidTree {

    static boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        assertThat(validTree(5, Util.twoDIntArrayFromString("[[0,1],[0,2],[0,3],[1,4]]"))).isTrue();
    }
}
