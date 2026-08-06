class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for(int e: nums){
            minHeap.add((long) e);
        }   

        int step = 0;
        while(minHeap.size() >= 2){
            long x = minHeap.poll();
            if(x >= k){
                break;
            }

            long y = minHeap.poll();
            long newValue = (long) 2*x + (long) y;
            minHeap.add(newValue);
            step += 1;
        }
        return step;
    }
}