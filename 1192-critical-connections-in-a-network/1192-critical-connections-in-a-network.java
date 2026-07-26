class Solution {
    static int[] visited;
    static int[] timeOfInsertion;
    static int[] lowestTime;
    static List<List<Integer>> adj;

    static void dfs(int curr,int parent, int timer, List<List<Integer>> ans){
        visited[curr] = 1;
        timeOfInsertion[curr] = timer;
        lowestTime[curr] = timer;

        for(int nei: adj.get(curr)){
            if(nei==parent) continue;
            else if(visited[nei]==0){
                dfs(nei,curr,timer+1,ans);
                lowestTime[curr] = Math.min(lowestTime[nei],lowestTime[curr]);
                if(lowestTime[nei] > timeOfInsertion[curr]){
                    ans.add(new ArrayList<>(Arrays.asList(curr,nei)));
                }
            }
            else lowestTime[curr] = Math.min(lowestTime[nei],lowestTime[curr]);
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
        dfs(0,-1,0,criticals);
        return criticals;
    }
}