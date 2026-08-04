class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int e : nums) {
            maxHeap.add(e);
        }

        while (k > 0) {
            int value = maxHeap.poll();
            score += value;
            double q = value / 3.0;
            maxHeap.add((int) Math.ceil(q));
            k -= 1;
        }
        return score;
    }
}