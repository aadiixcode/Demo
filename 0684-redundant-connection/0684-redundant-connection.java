class Solution {
    static class DSU{
        int[] parent;
        int[] rank;

        int findUltimate(int node){
            if(parent[node]==node){
                return node;
            }
            return parent[node] = findUltimate(parent[node]);
        }

        void union(int u, int v){
            int ultimateU = findUltimate(u);
            int ultimateV = findUltimate(v);

            int rankU = rank[ultimateU];
            int rankV = rank[ultimateV];
            
            if(rankU==rankV){
                parent[ultimateV] = ultimateU;
                rank[ultimateU] += 1;
            }
            else if(rankU>rankV){
                parent[ultimateV] = ultimateU;
            }
            else{
                parent[ultimateU] = ultimateV;
            }
        }

        DSU(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i; 
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU d = new DSU(n+1);

        int[] ans = new int[]{-1,-1};
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            int ultimateU = d.findUltimate(u);
            int ultimateV = d.findUltimate(v);
            // System.out.println(ultimateU + " "+ ultimateV);
            if(ultimateU == ultimateV){
                ans[0] = u;
                ans[1] = v;
            }else{
                d.union(u,v);
            }
        }
        return ans;
    }
}