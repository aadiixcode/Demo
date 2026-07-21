class Solution {
    static class DisjointSet {
        int[] size;
        int[] parent;

        int findUltimateParent(int node){
            if(parent[node]==node){
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]);
        }


        void unionBySize(int u, int v){
            int ultimateU = findUltimateParent(u);
            int ultimateV = findUltimateParent(v);

            if(ultimateU==ultimateV) return;

            int sizeU = size[ultimateU];
            int sizeV = size[ultimateV];

            if(sizeU<sizeV){
                parent[ultimateU] = ultimateV;
                size[ultimateV] += size[ultimateU];
            }
            else{
                parent[ultimateV] = ultimateU;
                size[ultimateU] += size[ultimateV];
            }
        }

        DisjointSet(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i<n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int totalRows = 0;
        int totalCols = 0;
        for(int i=0;i<n;i++){
            totalRows = Math.max(totalRows,stones[i][0]);
            totalCols = Math.max(totalCols,stones[i][1]);
        }

        int m= totalRows+totalCols+2;
        DisjointSet obj = new DisjointSet(m);
        for(int i=0;i<n;i++){
            int row = stones[i][0];
            int col = stones[i][1] + totalRows + 1;
            obj.unionBySize(row,col);
        }

        int totalComp = 0;
        for (int i=0;i<m;i++){
            int ultimate = obj.findUltimateParent(i);
            if(ultimate == i && obj.size[ultimate]>1){
                totalComp += 1;
            }
        }
        return stones.length - totalComp;
    }
}