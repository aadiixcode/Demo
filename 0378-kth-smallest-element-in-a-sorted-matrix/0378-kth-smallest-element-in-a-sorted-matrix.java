class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int element = matrix[i][j];
                if(pq.size() < k){
                    pq.add(element);
                }
                else if(pq.peek() > element){
                    pq.poll();
                    pq.add(element);
                }
                // else if(element >= pq.peek()){
                //     break;
                // }
            }
        }
        return pq.peek();
    }
}