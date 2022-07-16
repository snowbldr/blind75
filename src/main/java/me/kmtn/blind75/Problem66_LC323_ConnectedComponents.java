package me.kmtn.blind75;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
public class Problem66_LC323_ConnectedComponents {
    static int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(uf.union(edge[0], edge[1])){
                n--;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        assertThat(countComponents(4, Util.twoDIntArrayFromString("[[0,1],[2,3],[1,2]]"))).isEqualTo(1);
        assertThat(countComponents(5, Util.twoDIntArrayFromString("[[0,1],[1,2],[2,3],[3,4]]"))).isEqualTo(1);
        assertThat(countComponents(5, Util.twoDIntArrayFromString("[[0,1],[1,2],[3,4]]"))).isEqualTo(2);
    }
}
