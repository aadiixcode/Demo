class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if(n==0){
            return new int[n];
        }
        int[][] temp = new int[n][2];


        for(int i=0;i<n;i++){
            temp[i][0] = arr[i];
            temp[i][1] = i;
        }
        Arrays.sort(temp,(a,b) -> a[0]-b[0]);

        int[] rank = new int[n];
        int val = temp[0][0];
        int ind = temp[0][1];
        rank[ind] = 1;

        for(int i=1;i<n;i++){
            if(temp[i-1][0]==temp[i][0]){
                rank[temp[i][1]] = rank[temp[i-1][1]];
            }else{
                rank[temp[i][1]] = rank[temp[i-1][1]]+1;
            }
        }
        return rank;
    }
}