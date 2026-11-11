class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0, rightMax = 0, l = 0, r = n - 1;
        int sum = 0;
        while (l < r) {
            leftMax = Math.max(leftMax,height[l]);
            rightMax = Math.max(rightMax,height[r]);
            if (leftMax < rightMax) {
                sum += (leftMax - height[l]);
                l += 1;
            } else {
                sum += (rightMax - height[r]);
                r -= 1;
            }
        }
        return sum;
    }
}