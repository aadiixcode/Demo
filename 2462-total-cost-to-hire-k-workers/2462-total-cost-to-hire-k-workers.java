class Solution {
    static class Pair {
        int cost, index;

        Pair(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int i = 0, j = costs.length - 1;

        long totalCost = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.cost == b.cost) {
                return a.index - b.index;
            }
            return a.cost - b.cost;
        });

        int leftPart = 0, rightPart = 0;
        while (k > 0) {
            while (leftPart < candidates && i <= j) {
                pq.add(new Pair(costs[i], i));
                leftPart += 1;
                i += 1;
            }
            while (rightPart < candidates && j >= i) {
                pq.add(new Pair(costs[j], j));
                rightPart += 1;
                j -= 1;
            }
            // System.out.println()

            Pair p = pq.poll();
            totalCost += p.cost;
            int index = p.index;
            k -= 1;

            if (index < i) {
                leftPart -= 1;
            } else if (index > j) {
                rightPart -= 1;
            }
        }
        return totalCost;
    }
}