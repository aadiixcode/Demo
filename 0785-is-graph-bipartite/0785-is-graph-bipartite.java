class Solution {
    static int[] vis;

    static boolean bfs(int i,int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nei: graph[curr]){
                if(vis[nei]!=-1 && vis[nei]==vis[curr]){
                    return false;
                }
                else if(vis[nei]==-1){
                    if(vis[curr]==0){
                        vis[nei]=1;
                    }
                    else{
                        vis[nei]=0;
                    }
                    q.add(nei);
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;

        vis = new int[nodes];
        Arrays.fill(vis,-1);

        for(int i=0;i<nodes;i++){
            if(vis[i]==-1){
                if(!bfs(i,graph)) return false;
            }
        }
        return true;
    }
}