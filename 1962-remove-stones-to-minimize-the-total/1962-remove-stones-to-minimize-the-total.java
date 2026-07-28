class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int e : piles) {
            pq.add(e);
        }

        while (k != 0) {
            int pile = pq.poll();
            int newPile = (pile+1)/2;
            pq.add(newPile);
            k -= 1;
        }

        int remainingStones = 0;
        while(!pq.isEmpty()){
            remainingStones += pq.poll();
        }
        return remainingStones;
    }
}