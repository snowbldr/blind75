package me.kmtn.blind75;

class UnionFind {
    int[] parents;
    int[] componentSize;

    public UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        componentSize = new int[n];
        java.util.Arrays.fill(componentSize, 1);
    }

    int find(int n) {
        int parent = n;
        while (parent != this.parents[parent]) {
            parent = this.parents[parent];
        }
        while (n != parent) {
            int oldP = this.parents[n];
            this.parents[n] = parent;
            n = oldP;
        }
        return parent;
    }

    boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        //already part of the same component
        if (pa == pb) {
            return false;
        }

        if (componentSize[pa] > componentSize[pb]) {
            parents[pb] = pa;
            componentSize[pa] += componentSize[pb];
        } else {
            parents[pa] = pb;
            componentSize[pb] += componentSize[pa];
        }
        return true;
    }
}
