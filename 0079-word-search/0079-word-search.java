class Solution {
    static int[][] nei = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    boolean helper(int index, int n, int m, int row, int col, String target, char[][] board) {
        if (index == target.length()) {
            return true;
        }
        if (row < 0 || row >= n || col < 0 || col >= m || board[row][col] == '$') {
            return false;
        }
        if (board[row][col] != target.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '$';
        for (int i = 0; i < 4; i++) {
            int nr = row + nei[i][0];
            int nc = col + nei[i][1];
            if (helper(index + 1, n, m, nr, nc, target, board)) {
                return true;
            }
        }
        board[row][col] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && helper(0, n, m, i, j, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }
}