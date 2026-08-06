class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int e : nums) {
            minHeap.add(e);
        }

        int steps = 0;
        while (!minHeap.isEmpty()) {
            int e = minHeap.poll();
            if (e >= k) {
                break;
            }
            steps += 1;
        }
        return steps;
    }
}