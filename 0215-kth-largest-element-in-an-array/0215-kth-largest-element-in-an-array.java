class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int e: nums){
            if(pq.size()<k){
                pq.add(e);
            }else{
                if(e > pq.peek()){
                    pq.remove();
                    pq.add(e);
                }
            }
        }
        return pq.peek();
    }
}