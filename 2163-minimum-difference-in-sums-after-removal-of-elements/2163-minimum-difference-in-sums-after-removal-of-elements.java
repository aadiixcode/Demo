class Solution {
    public long minimumDifference(int[] arr) {
        int n = arr.length / 3;

        long[] leftMinSum = new long[3 * n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long leftSum = 0;
        for (int i = 0; i < 2 * n; i++) {
            leftSum += arr[i];
            maxHeap.add(arr[i]);
            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            leftMinSum[i] = leftSum;
        }

        long[] rightMaxSum = new long[3 * n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;
        for (int i = 3 * n - 1; i >= n; i--) {
            rightSum += arr[i];
            minHeap.add(arr[i]);
            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            rightMaxSum[i] = rightSum;
        }

        long ans = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            long left = leftMinSum[i];
            long right = rightMaxSum[i + 1];
            long diff = left - right;
            ans = Math.min(ans, diff);
        }
        return ans;
    }
}