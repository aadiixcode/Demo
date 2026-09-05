class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int minCandies = n;
        int i = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i += 1;
                continue;
            }

            int peak = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                i += 1;
                peak += 1;
                minCandies += peak;
            }

            int dip = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                i += 1;
                dip += 1;
                minCandies += dip;
            }
            minCandies -= Math.min(peak, dip);
        }
        return minCandies;
    }
}