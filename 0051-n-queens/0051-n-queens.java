class Solution {
    boolean isSafe(char[][] arr, int n, int row, int col) {
        int duprow = row, dupcol = col;

        for (int i = row - 1; i >= 0; i--) {
            if (arr[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (arr[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    void helper(int row, int n, char[][] arr, List<List<String>> ans) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(arr[i][j]);
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(arr, arr.length, row, col)) {
                arr[row][col] = 'Q';
                helper(row + 1, n, arr, ans);
                arr[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '.';
            }
        }
        helper(0, n, arr, ans);
        return ans;
    }
}