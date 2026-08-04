class Solution {
    public void moveZeroes(int[] nums) {
        int zeroStartInd = -1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                zeroStartInd = i;
                break;
            }
            i += 1;
        }
        while (i < nums.length) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[zeroStartInd];
                nums[zeroStartInd] = temp;
                zeroStartInd += 1;
            }
            i += 1;
        }
    }
}