class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int steps = 0;
        for (int e : nums) {
            if (e >= k) {
                return steps;
            }
            steps += 1;
        }
        return steps;
    }
}