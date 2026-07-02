class Solution {
    boolean DFS(int node, int[][] adjList, int[] visited){
        visited[node] = 1;
        for (int e: adjList[node]){
            if (visited[e]==0){
                if (DFS(e, adjList, visited)) return true;
            }
            else if (visited[e]==1) return true;
        }
        visited[node] = 2;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] adjList) {
        int[] visited = new int[adjList.length];
        for (int i=0;i< adjList.length;i++){
            if (visited[i]==0){
                DFS(i,adjList,visited);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<visited.length;i++){
            if (visited[i]==2)
                res.add(i);
        }
        return res;
    }
}