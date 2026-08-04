class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = Integer.MIN_VALUE;
        int count = 0;
        for (int e : nums) {
            if (e == 0) {
                maxCount = Math.max(maxCount, count);
                count = 0;
            } else {
                count += 1;
            }
        }
        return Math.max(maxCount, count);
    }
}