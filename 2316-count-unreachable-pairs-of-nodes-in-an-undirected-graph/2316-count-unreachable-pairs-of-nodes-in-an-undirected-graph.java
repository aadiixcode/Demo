class Solution {
    static int dfs(int node, List<List<Integer>> adj, int[] vis) {
        vis[node] = 1;
        int count = 1;
        for (int nei : adj.get(node)) {
            if (vis[nei] == 0) {
                count += dfs(nei, adj, vis);
            }
        }
        return count;
    }

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        long total = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                long noOfNodes = dfs(i, adj, vis);
                total += noOfNodes;
                ans += noOfNodes * (n - total);
            }
        }
        return ans;
    }
}