class Solution {

    public int[] findPeakGrid(int[][] mat) {
        int low = 0, high = mat.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxIndex = 0, maxValue = mat[mid][0];
            for (int i = 1; i < mat[mid].length; i++) {
                if (mat[mid][i] > maxValue) {
                    maxValue = mat[mid][i];
                    maxIndex = i;
                }
            }
            if (mid - 1 >= 0 && mat[mid - 1][maxIndex] > maxValue) {
                high = mid - 1;
            } else if (mid + 1 < mat.length && mat[mid + 1][maxIndex] > maxValue) {
                low = mid + 1;
            }
            else{
                return new int[]{mid,maxIndex};
            }
        }
        return new int[]{-1,-1};
    }
}