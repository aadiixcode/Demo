class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int totalSum = 0;
        for (int e : piles) {
            pq.add(e);
            totalSum += e;
        }

        while (k != 0) {
            int pile = pq.poll();
            int newPile = (pile+1)/2;
            totalSum -= (pile - newPile);
            pq.add(newPile);
            k -= 1;
        }
        return totalSum;
    }
}