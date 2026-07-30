class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int e : nums) {
            if (pq.size() < k) {
                pq.add(e);
            } 
            else {
                if (e > pq.peek()) {
                    pq.remove();
                    pq.add(e);
                }
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.remove();
        }
        return pq.size() > 0 ? pq.peek() : Integer.MIN_VALUE;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */