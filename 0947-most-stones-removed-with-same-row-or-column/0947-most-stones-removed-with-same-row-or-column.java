class Solution {
    static void dfs(int node,int[] vis,int[][] stones){
        vis[node]=1;
        int r = stones[node][0];
        int c = stones[node][1];

        for(int i=0;i<stones.length;i++){
            if((vis[i]==0) && (stones[i][0]==r || stones[i][1]==c)){
                dfs(i,vis,stones);
            }   
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int totalComp = 0;
        int[] vis = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,vis,stones);
                totalComp+=1;
            }
        }
        return n-totalComp;
    }
}