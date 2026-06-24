class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int[][][] arr = new int[n + 1][m + 1][2];
        int mod = 1_000_000_007;

        for (int start = 1; start <= m; start++) {
            arr[n][start][1] = 1;
            arr[n][start][0] = 1;
        }

        for (int i = n - 1; i > 0; i--) {
            int[] increasingPrefix = new int[m + 1];
            int[] decreasingPrefix = new int[m + 1];

            for (int prev = 1; prev <= m; prev++) {
                increasingPrefix[prev] = (increasingPrefix[prev - 1] + arr[i + 1][prev][0]) % mod;
                decreasingPrefix[prev] = (decreasingPrefix[prev - 1] + arr[i + 1][prev][1]) % mod;
            }

            for (int prev = 1; prev <= m; prev++) {
                arr[i][prev][1] = (increasingPrefix[m] - increasingPrefix[prev] + mod) % mod;
                arr[i][prev][0] = decreasingPrefix[prev - 1];
            }
        }

        int res = 0;
        for (int start = 1; start <= m; start++) {
            res = (res + arr[1][start][1]) % mod;
            res = (res + arr[1][start][0]) % mod;
        }
        return res;
    }
}
