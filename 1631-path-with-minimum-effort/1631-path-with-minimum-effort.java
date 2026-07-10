class Solution {
    static class Pair{
        int row,col,effort;
        Pair(int r,int c,int e){
            row=r;
            col=c;
            effort=e;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];

        for(int[] arr:dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        int[] rows = {0,-1,0,1};
        int[] cols = {-1,0,1,0};

        dist[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.effort - b.effort);
        pq.add(new Pair(0,0,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int cr = p.row;
            int cc = p.col;
            int ce = p.effort;

            if(cr==n-1 && cc==m-1){
                break;
            }

            for(int i=0;i<4;i++){
                int nr = rows[i]+cr;
                int nc = cols[i]+cc;

                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int ne = Math.abs(heights[cr][cc]-heights[nr][nc]);
                    int maxEffortInPath = Math.max(ne,ce);

                    if(maxEffortInPath < dist[nr][nc]){
                        dist[nr][nc] = maxEffortInPath;
                        pq.add(new Pair(nr,nc,maxEffortInPath));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}