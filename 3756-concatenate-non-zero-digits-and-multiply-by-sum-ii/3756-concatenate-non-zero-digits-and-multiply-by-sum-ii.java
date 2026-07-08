class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] prefixNum = new long[n];
        int[] digitSum = new int[n];
        int[] nonZeroDigit = new int[n];
        int mod = 1000000007;

        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
        }

        int sum = 0, nonZero = 0;
        long number = 0;
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (digit > 0) {
                nonZero += 1;
                number = (number * 10 + digit) % mod;
                sum += digit;
            }

            digitSum[i] = sum;
            prefixNum[i] = number;
            nonZeroDigit[i] = nonZero;
        }

        // System.out.println(Arrays.toString(prefixNum));
        // System.out.println(Arrays.toString(digitSum));
        // System.out.println(Arrays.toString(nonZeroDigit));
        // System.out.println(Arrays.toString(pow10));

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int extraDigits = 0;
            if (l > 0) {
                extraDigits = nonZeroDigit[r] - nonZeroDigit[l - 1];
            }
            long x = prefixNum[r];
            int tempSum = digitSum[r];
            if (l > 0) {
                x = (x - (prefixNum[l - 1] * pow10[extraDigits]) % mod + mod) % mod;
                tempSum = tempSum - digitSum[l - 1];
            }

            ans[i] = (int)((x * tempSum) % mod);
        }
        return ans;
    }
}