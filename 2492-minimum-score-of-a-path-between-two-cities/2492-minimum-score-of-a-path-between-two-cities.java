class Solution {
    static class Pair{
        int node,weight;
        Pair(int n,int w){
            node = n;
            weight = w;
        }
    }

    static void dfs(int node,int[] vis,List<List<Pair>> adj,int[] ans){
        vis[node] = 1;

        for(Pair p: adj.get(node)){
            int v = p.node;
            int w = p.weight;
            ans[0] = Math.min(ans[0],w);
            if(vis[v]==0){
                dfs(v,vis,adj,ans);
            }
        }
    }


    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road: roads){
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        int[] ans = {Integer.MAX_VALUE};
        int[] vis = new int[n+1];

        dfs(1,vis,adj,ans);
        return ans[0];
    }
}