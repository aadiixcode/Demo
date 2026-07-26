class Solution {
    static int[] vis;
    static int[] dt;
    static int[] low;
    static List<List<Integer>> adj;

    static void dfs(int node, List<List<Integer>> criticals, int dTime, int parent) {
        vis[node] = 1;
        dt[node] = dTime;
        low[node] = dTime;

        for (int nei : adj.get(node)) {
            if (vis[nei] == 0) {
                dfs(nei, criticals, dTime + 1, node);
            }
            if (nei != parent) {
                low[node] = Math.min(low[node], low[nei]);
                if (low[nei] > dt[node]) {
                    List<Integer> edge = new ArrayList<>();
                    edge.add(node);
                    edge.add(nei);
                    criticals.add(edge);
                }
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        vis = new int[n];
        dt = new int[n];
        low = new int[n];

        List<List<Integer>> criticals = new ArrayList<>();
        dfs(0, criticals, 0, -1);
        return criticals;
    }
}