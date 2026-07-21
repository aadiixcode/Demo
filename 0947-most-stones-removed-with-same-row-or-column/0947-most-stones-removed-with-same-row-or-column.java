class Solution {
    static class DisjointSet {
        int[] rank;
        int[] parent;

        DisjointSet(int n) {
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int findUltimateParent(int node) {
            if (node == parent[node])
                return node;
            return parent[node] = findUltimateParent(parent[node]);
        }

        void unionByRank(int u, int v) {
            int ultimateU = findUltimateParent(u);
            int ultimateV = findUltimateParent(v);
            if (ultimateU == ultimateV)
                return;

            int rankU = rank[ultimateU];
            int rankV = rank[ultimateV];
            if (rankU < rankV)
                parent[ultimateU] = ultimateV;
            else if (rankV < rankU)
                parent[ultimateV] = ultimateU;
            else {
                parent[ultimateV] = ultimateU;
                rank[ultimateU] = rankU + 1;
            }
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        DisjointSet d = new DisjointSet(n);

        for (int u = 0; u < n; u++) {
            int r = stones[u][0];
            int c = stones[u][1];
            for (int v = u + 1; v < n; v++) {
                if (stones[v][0] == r || stones[v][1] == c) {
                    d.unionByRank(u, v);
                }
            }
        }

        int totalComp = 0;
        for (int i = 0; i < n; i++) {
            if (d.parent[i] == i) {
                totalComp += 1;
            }
        }
        return n - totalComp;
    }
}