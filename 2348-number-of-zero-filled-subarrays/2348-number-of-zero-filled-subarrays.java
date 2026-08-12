class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int i = 0, j = 0;
        long count = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                long length = j - i;
                long numberOfSubstrings = (length * (length + 1)) / 2;
                count += numberOfSubstrings;
                i = j + 1;
            }
            j += 1;
        }
        long length = j - i;
        long numberOfSubstrings = (length * (length + 1)) / 2;
        count += numberOfSubstrings;
        return count;
    }
}