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

        for (int i = 0; i < n; i++) {
            int r = stones[i][0];
            int c = stones[i][1];

            for (int j = i + 1; j < n; j++) {
                if (stones[j][0] == r || stones[j][1] == c) {
                    int u = i;
                    int v = j;
                    int ultimateU = d.findUltimateParent(u);
                    int ultimateV = d.findUltimateParent(v);

                    if (ultimateU != ultimateV) {
                        d.unionByRank(u, v);
                    }
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