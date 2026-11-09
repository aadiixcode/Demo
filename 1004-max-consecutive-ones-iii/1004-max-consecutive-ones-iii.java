class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, zeroStartInd = -1, zeroCount = k, maxLen = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                zeroCount -= 1;
            }
            if (zeroCount < 0) {
                while (i < nums.length) {
                    if (nums[i] == 0) {
                        i += 1;
                        zeroCount = 0;
                        break;
                    }
                    i += 1;
                }
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j += 1;
        }
        return maxLen;
    }
}