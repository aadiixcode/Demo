class Solution {
    static int[] vis;

    static boolean dfs(int i,int[][] graph){
        Stack<Integer> st = new Stack<>();
        st.add(i);
        vis[i] = 0;

        while(!st.isEmpty()){
            int curr = st.pop();
            for(int nei: graph[curr]){
                if(vis[nei]!=-1 && vis[nei]==vis[curr]){
                    return false;
                }
                else if(vis[nei]==-1){
                    vis[nei] = (vis[curr]==0) ? 1 : 0;
                    st.push(nei);
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
                if(!dfs(i,graph)) return false;
            }
        }
        return true;
    }
}