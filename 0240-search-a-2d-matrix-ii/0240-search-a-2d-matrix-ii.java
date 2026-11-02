class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[row].length - 1;
        while (col >= 0 && row < matrix.length) {
            int val = matrix[row][col];
            if (val == target) {
                return true;
            } else if (target > val) {
                row += 1;
            } else {
                col -= 1;
            }
        }
        return false;
    }
}