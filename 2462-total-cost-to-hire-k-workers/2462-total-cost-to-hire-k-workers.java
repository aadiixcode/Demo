class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int i = 0, j = n - 1;

        long totalCost = 0;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        while (k > 0) {
            while (pq1.size() < candidates && i <= j) {
                pq1.add(costs[i]);
                i += 1;
            }
            while (pq2.size() < candidates && j >= i) {
                pq2.add(costs[j]);
                j -= 1;
            }

            int leftMin = pq1.isEmpty() ? Integer.MAX_VALUE : pq1.peek();
            int rightMin = pq2.isEmpty() ? Integer.MAX_VALUE : pq2.peek();

            if (leftMin <= rightMin) {
                totalCost += pq1.poll();
                k -= 1;
            } else {
                totalCost += pq2.poll();
                k -= 1;
            }
        }
        return totalCost;
    }
}