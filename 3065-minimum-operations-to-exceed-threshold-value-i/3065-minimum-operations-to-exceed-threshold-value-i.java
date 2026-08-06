class Solution {
    public int minOperations(int[] nums, int k) {
        int lessThank = 0;
        for (int e : nums) {
            if (e < k) {
                lessThank += 1;
            }
        }
        return lessThank;
    }
}