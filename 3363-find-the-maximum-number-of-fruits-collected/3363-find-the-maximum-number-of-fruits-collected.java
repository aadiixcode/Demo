class Solution {
    int[][] dp2, dp3;

    int c1(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
            arr[i][i] = 0;
        }
        System.out.println(sum);
        return sum;
    }

    int c2(int i, int j, int n, int[][] arr) {
        if (i > j) {
            return 0;
        }
        if (i >= n || j < 0 || j >= n) {
            return 0;
        }

        if (dp2[i][j] != -1) {
            return dp2[i][j];
        }

        int antiDiag = c2(i + 1, j - 1, n, arr);
        int down = c2(i + 1, j, n, arr);
        int diag = c2(i + 1, j + 1, n, arr);

        int sum = arr[i][j] + Math.max(antiDiag, Math.max(diag, down));

        return dp2[i][j] = sum;

    }

    int c3(int i, int j, int n, int[][] arr) {
        if (i < j) {
            return 0;
        }
        if (i < 0 || i >= n || j >= n) {
            return 0;
        }

        if (dp3[i][j] != -1) {
            return dp3[i][j];
        }

        int antiDiag = c3(i - 1, j + 1, n, arr);
        int down = c3(i, j + 1, n, arr);
        int diag = c3(i + 1, j + 1, n, arr);

        int sum = arr[i][j] + Math.max(antiDiag, Math.max(diag, down));

        return dp3[i][j] = sum;
    }

    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        dp2 = new int[n][n];
        dp3 = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp2[i], -1);
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp3[i], -1);
        }

        return c1(fruits) + c2(0, n - 1, n, fruits) + c3(n - 1, 0, n, fruits);
    }
}