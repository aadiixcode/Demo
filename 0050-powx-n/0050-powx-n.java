class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        long temp = Math.abs((long) n);
        double ans = 1;
        while (temp > 1) {
            if (temp % 2 == 0) {
                x = x * x;
                temp = temp / 2;
            } else {
                ans = ans * x;
                temp -= 1;
            }
        }
        ans = ans * x;

        if (n < 0) {
            return 1 / ans;
        }
        return ans;
    }
}