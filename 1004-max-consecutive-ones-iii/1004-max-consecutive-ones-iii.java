class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, zeroCount = k, maxLen = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                zeroCount -= 1;
            }
            if (zeroCount < 0) {
                if (nums[i] == 0) {
                    zeroCount += 1;
                }
                i += 1;
            }
            if (zeroCount >= 0) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            j += 1;
        }
        return maxLen;
    }
}