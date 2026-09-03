class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int left = 0, right = 0;
        while (right < n - 1) {
            jumps += 1;
            int maxWeCanReach = -1;
            for (int options = left; options <= right; options++) {
                maxWeCanReach = Math.max(maxWeCanReach,options + nums[options]);
            }
            left = right + 1;
            right = maxWeCanReach;
        }
        return jumps;
    }
}