class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] sortedArr = new int[n*n];

        int ind = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sortedArr[ind++] = matrix[i][j];
            }
        }
        Arrays.sort(sortedArr);
        return sortedArr[k-1];
    }
}