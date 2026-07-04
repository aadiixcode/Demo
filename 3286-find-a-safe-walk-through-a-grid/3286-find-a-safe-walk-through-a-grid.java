class Solution {
    static class Pair{
        int row,col;
        Pair(int r,int c){
            row=r;col=c;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] result = new int[n][m];
        for(int[] arr: result){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        result[0][0] = grid.get(0).get(0);

        int[] rows = {0,-1,0,1};
        int[] cols = {-1,0,1,0};

        Deque<Pair> dq = new ArrayDeque<>();
        dq.addFirst(new Pair(0,0));
        while(!dq.isEmpty()){
            Pair p = dq.pollFirst();
            int r = p.row, c = p.col;
            for(int i=0;i<4;i++){
                int nr = rows[i]+r,nc=cols[i]+c;
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    if(result[r][c] + grid.get(nr).get(nc) < result[nr][nc]){
                        result[nr][nc] = result[r][c] + grid.get(nr).get(nc);
                        if(result[nr][nc]==0){
                            dq.addFirst(new Pair(nr,nc));
                        }
                        else{
                            dq.addLast(new Pair(nr,nc));
                        }
                    }
                }
            }
        }

        if(health - result[n-1][m-1] >= 1){
            return true;
        }
        return false;
    }
}