class Solution {
    static class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> {
            if(a.value==b.value){
                return Integer.compare(a.index,b.index);
            }
            return a.value - b.value;
        });

        for(int i=0;i<n;i++){
            minHeap.add(new Pair(nums[i],i));
        }
        boolean[] vis = new boolean[n];

        long score = 0;
        while(!minHeap.isEmpty()){
            Pair p = minHeap.poll();
            int value = p.value;
            int index = p.index;
            if(vis[index]==true){
                continue;
            }

            score += value;
            vis[index] = true;
            if(index-1>=0){
                vis[index-1] = true;
            }
            if(index+1 < n){
                vis[index+1] = true;
            }
        }
        return score;
    }
}