class Solution {
    boolean isSafe(char[][] arr, int n, int row, int col) {
        int duprow = row, dupcol = col;
        while (row >= 0 && col >= 0) {
            if (arr[row][col] == 'Q') {
                return false;
            }
            row -= 1;
            col -= 1;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (arr[row][col] == 'Q') {
                return false;
            }
            col -= 1;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < n) {
            if (arr[row][col] == 'Q') {
                return false;
            }
            row += 1;
            col -= 1;
        }

        return true;
    }

    void helper(int col, int n, char[][] arr, List<List<String>> ans) {
        if (col == n) {
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

        for (int row = 0; row < n; row++) {
            if (isSafe(arr, arr.length, row, col)) {
                arr[row][col] = 'Q';
                helper(col + 1, n, arr, ans);
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