class Solution {

    static int getDepth(List<List<Integer>> adj, int node, int parent) {
        int maxDepth = 0;
        for (int nei : adj.get(node)) {
            if (nei == parent)
                continue;
            maxDepth = Math.max(maxDepth, getDepth(adj, nei, node) + 1);
        }
        return maxDepth;
    }

    static int power(int x, int n) {
        long ans = 1;
        long base = x;
        int MOD = 1000000007;
        while (n > 0) {
            if (n % 2 == 0) {
                base = (base * base) % MOD;
                n /= 2;
            } else {
                ans = (ans * base) % MOD;
                n -= 1;
            }
        }
        return (int) ans;
    }

    public int assignEdgeWeights(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= edges.length + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int d = getDepth(adj, 1, -1);
        return power(2, d - 1);
    }
}