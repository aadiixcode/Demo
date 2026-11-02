class Solution {
    boolean bs(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int startValue = matrix[mid][0];
            int endValue = matrix[mid][matrix[mid].length - 1];
            if (target < startValue) {
                high = mid - 1;
            } else if (target > endValue) {
                low = mid + 1;
            } else {
                return bs(matrix[mid], target);
            }
        }
        return false;
    }
}