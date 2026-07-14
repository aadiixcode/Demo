class Solution {

    static int[][][] dp;
    static int mod = 1000000007;

    static int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        if (a == 0)
            return b;
        return a;
    }

    static int helper(int[] arr, int index, int gcd1, int gcd2) {
        if (index == arr.length) {
            if (gcd1 != 0 && gcd1 == gcd2) {
                return 1;
            }
            return 0;
        }
        if (dp[index][gcd1][gcd2] != -1) {
            return dp[index][gcd1][gcd2];
        }

        int skip = helper(arr, index + 1, gcd1, gcd2);
        int inSeq1 = helper(arr, index + 1, gcd(gcd1, arr[index]), gcd2);
        int inSeq2 = helper(arr, index + 1, gcd1, gcd(gcd2, arr[index]));
        return dp[index][gcd1][gcd2] = (int)(((long)skip + inSeq1 + inSeq2) % mod);
    }

    public int subsequencePairCount(int[] nums) {
        dp = new int[nums.length][201][201];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                for(int k=0;k<dp[i][j].length;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return helper(nums, 0, 0, 0);
    }

}