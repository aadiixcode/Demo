class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int diff, int[][] queries) {
        int[] component = new int[n];
        component[0] = 0;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=diff){
                component[i] = component[i-1];
            }
            else{
                component[i] = component[i-1]+1;
            }
        }

        boolean[] path = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            if(component[queries[i][0]]==component[queries[i][1]]){
                path[i] = true;
            }
        }
        return path;
    }
}