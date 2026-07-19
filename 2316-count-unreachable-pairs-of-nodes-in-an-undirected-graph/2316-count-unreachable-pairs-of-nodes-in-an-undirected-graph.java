class Solution {
    static class DisjointSet {
        int[] size;
        int[] parent;

        int findUltimateParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]);
        }

        void unionBySize(int u, int v) {
            int ultimateU = findUltimateParent(u);
            int ultimateV = findUltimateParent(v);

            if (ultimateU == ultimateV)
                return;

            int sizeU = size[ultimateU];
            int sizeV = size[ultimateV];

            if (sizeU < sizeV) {
                parent[ultimateU] = ultimateV;
                size[ultimateV] += size[ultimateU];
            } else {
                parent[ultimateV] = ultimateU;
                size[ultimateU] += size[ultimateV];
            }
        }

        DisjointSet(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }
    }

    public long countPairs(int n, int[][] edges) {
        DisjointSet d = new DisjointSet(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int ultimateU = d.findUltimateParent(u);
            int ultimateV = d.findUltimateParent(v);

            if (ultimateU != ultimateV) {
                d.unionBySize(u, v);
            }
        }

        long total = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (d.parent[i] == i) {
                total += d.size[i];
                ans += d.size[i] * (n-total);
            }
        }
        return ans;
    }
}