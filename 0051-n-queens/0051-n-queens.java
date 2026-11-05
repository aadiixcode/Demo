class Solution {
    void helper(int row, int n, char[][] arr, List<List<String>> ans, int[] cols, int[] diagonals,
            int[] antiDiagonals) {
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
            if (cols[col] == 0 && diagonals[row + col] == 0 &&
                    antiDiagonals[row - col + n - 1] == 0) {
                arr[row][col] = 'Q';

                cols[col] = 1;
                diagonals[row + col] = 1;
                antiDiagonals[row - col + n - 1] = 1;

                helper(row + 1, n, arr, ans, cols, diagonals, antiDiagonals);

                // Backtracking
                arr[row][col] = '.';

                cols[col] = 0;
                diagonals[row + col] = 0;
                antiDiagonals[row - col + n - 1] = 0;
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

        int[] cols = new int[n];
        int[] diagonals = new int[2 * n - 1];
        int[] antiDiagonals = new int[2 * n - 1];

        helper(0, n, arr, ans, cols, diagonals, antiDiagonals);
        return ans;
    }
}