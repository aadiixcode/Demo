class Solution {
    static void dfs(int node, int[] vis, List<List<Integer>> adj, int currDist, int[] maxDist, int[] end) {
        vis[node] = 1;
        for (int nei : adj.get(node)) {
            if (vis[nei] == 0) {
                if (currDist + 1 > maxDist[0]) {
                    maxDist[0] = currDist + 1;
                    end[0] = nei;
                }
                dfs(nei, vis, adj, currDist + 1, maxDist, end);
            }
        }
    }

    static int findDiameter(int n, int[][] edges) {
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
        int[] maxDist = { 0 };
        int[] oneEnd = { 0 };
        dfs(0, vis, adj, 0, maxDist, oneEnd);

        vis = new int[n];
        maxDist[0] = 0;
        int[] otherEnd = { oneEnd[0] };
        dfs(oneEnd[0], vis, adj, 0, maxDist, otherEnd);

        return maxDist[0];
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = findDiameter(edges1.length+1,edges1);
        int d2 = findDiameter(edges2.length+1,edges2);

        int afterMerging = (d1+1)/2 + (d2+1)/2 + 1;
        return Math.max(afterMerging,Math.max(d1,d2));
    }
}