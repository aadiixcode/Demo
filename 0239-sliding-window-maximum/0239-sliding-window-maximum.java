class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];

        int ansIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int lastAllowedIndex = i - k;
            while (!dq.isEmpty() && dq.peekFirst() <= lastAllowedIndex) {
                dq.pop();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {
                ans[ansIndex++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}