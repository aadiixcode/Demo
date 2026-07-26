class Solution {
    static int[] visited;
    static int[] timeOfInsertion;
    static int[] lowestTime;
    static List<List<Integer>> adj;

    static void dfs(int node, List<List<Integer>> criticals, int timer, int parent) {
        visited[node] = 1;
        timeOfInsertion[node] = timer;
        lowestTime[node] = timer;

        for (int nei : adj.get(node)) {
            if (visited[nei] == 0) {
                dfs(nei, criticals, timer + 1, node);
            }
            if (nei != parent) {
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[nei]);
            }
            if (lowestTime[nei] > timeOfInsertion[node]) {
                List<Integer> edge = new ArrayList<>();
                edge.add(node);
                edge.add(nei);
                criticals.add(edge);
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

        visited = new int[n];
        timeOfInsertion = new int[n];
        lowestTime = new int[n];

        List<List<Integer>> criticals = new ArrayList<>();
        dfs(0, criticals, 0, -1);
        return criticals;
    }
}