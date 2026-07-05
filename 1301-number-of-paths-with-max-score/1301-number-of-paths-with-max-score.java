class Solution {

    static class Pair {
        int score, paths;

        Pair(int s, int p) {
            score = s;
            paths = p;
        }
    }

    static boolean isValid(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    static int getValue(char ch) {
        return ch == 'S' ? 0 : ch - '0';
    }

    static int n;
    static List<List<int[]>> dp;

    static int[] helper(int row, int col, List<String> board) {
        if (board.get(row).charAt(col) == 'E') {
            return new int[] { 0, 1 };
        }
        if (board.get(row).charAt(col) == 'X') {
            return new int[] { 0, 0 };
        }

        int[] arr = dp.get(row).get(col);
        if (arr[0] != -1 && arr[1] != -1) {
            return arr;
        }

        char ch = board.get(row).charAt(col);
        int leftScore = 0, leftPaths = 0;
        int upScore = 0, upPaths = 0;
        int diagonalScore = 0, diagonalPaths = 0;

        if (isValid(row, col - 1)) {
            int[] left = helper(row, col - 1, board);
            leftScore = left[0];
            leftPaths = left[1];
            if (leftPaths > 0) {
                leftScore += getValue(ch);
            }
        }

        if (isValid(row - 1, col)) {
            int[] up = helper(row - 1, col, board);
            upScore = up[0];
            upPaths = up[1];
            if (upPaths > 0) {
                upScore += getValue(ch);
            }
        }

        if (isValid(row - 1, col - 1)) {
            int[] diagonal = helper(row - 1, col - 1, board);
            diagonalScore = diagonal[0];
            diagonalPaths = diagonal[1];
            if (diagonalPaths > 0) {
                diagonalScore += getValue(ch);
            }
        }

        int bestScore = 0, bestPaths = 0;

        if (upScore == leftScore && leftScore == diagonalScore) {
            bestScore = leftScore;
            bestPaths = upPaths + leftPaths + diagonalPaths;
        } else if (upScore == leftScore) {
            bestScore = leftScore;
            bestPaths = upPaths + leftPaths;
            if (diagonalScore > bestScore ||
                    (diagonalScore == bestScore && diagonalPaths > bestPaths)) {
                bestScore = diagonalScore;
                bestPaths = diagonalPaths;
            }
        } else if (diagonalScore == leftScore) {
            bestScore = leftScore;
            bestPaths = diagonalPaths + leftPaths;
            if (upScore > bestScore ||
                    (upScore == bestScore && upPaths > bestPaths)) {
                bestScore = upScore;
                bestPaths = upPaths;
            }
        } else {
            bestScore = upScore;
            bestPaths = upPaths;
            if (leftScore > bestScore ||
                    (leftScore == bestScore && leftPaths > bestPaths)) {
                bestScore = leftScore;
                bestPaths = leftPaths;
            }
            if (diagonalScore > bestScore ||
                    (diagonalScore == bestScore && diagonalPaths > bestPaths)) {
                bestScore = diagonalScore;
                bestPaths = diagonalPaths;
            }
        }
        arr[0] = bestScore;
        arr[1] = bestPaths % 1000000007;
        return arr;
    }

    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();

        dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<int[]> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int[] arr = new int[2];
                Arrays.fill(arr, -1);
                row.add(arr);
            }
            dp.add(row);
        }

        int[] ans = helper(n - 1, n - 1, board);
        return ans;
    }
}

/**
E 2 3 
2 X 2
1 2 S

 */