class Solution {
    public int minimumAverageDifference(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;
        long ts = 0;
        for (int e : arr) {
            ts += e;
        }

        long cs = 0;
        int ans = -1;
        int minAvg = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            cs += arr[i];
            long leftSum = cs;
            long rightSum = ts - cs;

            long leftAvg = (leftSum == 0) ? 0 : leftSum / (i + 1);
            long rightAvg = (rightSum == 0) ? 0 : rightSum / (n - i - 1);

            // System.out.println(Math.abs(leftAvg-rightAvg));
            if (Math.abs(leftAvg - rightAvg) < minAvg) {
                minAvg = (int) Math.abs(leftAvg - rightAvg);
                ans = i;
            }
        }
        return ans;
    }
}