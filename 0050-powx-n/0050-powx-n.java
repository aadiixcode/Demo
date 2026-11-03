class Solution {
    public double myPow(double x, int n) {
        long temp = Math.abs((long) n);
        double ans = 1;
        while (temp > 0) {
            if (temp % 2 == 0) {
                x = x * x;
                temp = temp / 2;
            } else {
                ans = ans * x;
                temp -= 1;
            }
        }

        if (n < 0) {
            return 1 / ans;
        }
        return ans;
    }
}