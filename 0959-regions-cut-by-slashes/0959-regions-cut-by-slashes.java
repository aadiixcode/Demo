class Solution {

    static int[] rows = {0,-1,0,1};
    static int[] cols = {-1,0,1,0};
    static void dfs(int r, int c,int[][] mat){
        mat[r][c] = -1;
        for(int i=0;i<4;i++){
            int nr=rows[i]+r;
            int nc=cols[i]+c;
            if(nr>=0 && nr<mat.length && nc>=0 && nc<mat.length){
                if(mat[nr][nc]==0){
                    dfs(nr,nc,mat);
                }
            }
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] mat = new int[n*3][n*3];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i].charAt(j) == '/'){
                    mat[3*i+0][3*j+2] = 1;
                    mat[3*i+1][3*j+1] = 1;
                    mat[3*i+2][3*j+0] = 1;
                }else if(grid[i].charAt(j) == '\\'){
                    mat[3*i+0][3*j+0] = 1;
                    mat[3*i+1][3*j+1] = 1;
                    mat[3*i+2][3*j+2] = 1;
                }
            }
        }
        
        int region=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                if(mat[i][j]==0){
                    region+=1;
                    dfs(i,j,mat);
                }
            }
        }
        return region;
    }
}