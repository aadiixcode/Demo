class Solution {
    int findSum(int[] nums, int div) {
        int sum = 0;
        for (int e : nums) {
            sum += (e / div);
            if (e % div > 0) {
                sum += 1;
            }
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int e : nums) {
            max = Math.max(max, e);
        }

        int min = 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int sum = findSum(nums, mid);
            if (sum <= threshold) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}