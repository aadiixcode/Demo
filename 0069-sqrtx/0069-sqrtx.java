class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x;
        int ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) mid * mid > x) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
}