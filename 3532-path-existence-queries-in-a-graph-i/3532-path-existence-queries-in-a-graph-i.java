class Solution {

    static ArrayList<ArrayList<Integer>> adj;

    static void dfs(int node, int[] component, int comp) {
        component[node] = comp;
        for (int e : adj.get(node)) {
            if (component[e] == 0) {
                dfs(e, component, comp);
            }
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int diff, int[][] queries) {

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(nums[i] - nums[i + 1]) <= diff) {
                adj.get(i).add(i + 1);
                adj.get(i + 1).add(i);
            }
        }

        // System.out.println(adj);

        int[] component = new int[n];
        int comp = 1;
        for (int i = 0; i < n; i++) {
            if (component[i] == 0) {
                dfs(i, component, comp);
                comp += 1;
            }
        }

        // System.out.println(component);

        boolean[] path = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (component[queries[i][0]] == component[queries[i][1]]) {
                path[i] = true;
            }
        }
        return path;
    }
}