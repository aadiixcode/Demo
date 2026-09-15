class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        long left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                left += nums[i];
            } else {
                right += nums[i];
            }
        }

        int count = 0;
        int i = 0, j = n/2;
        while(i < n){
            if (left > right) {
                count += 1;
            }
            left -= nums[i];
            left += nums[j];
            right -= nums[j];
            right += nums[i];

            i = (i+1);
            j = (j+1) % n;
        }
        return count;
    }
}