class Solution {
    static class Pair {
        int ele;
        int freq;

        Pair(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int e: nums){
            mp.put(e,mp.getOrDefault(e,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.freq - b.freq);
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            int key  = entry.getKey();
            int value = entry.getValue();
            if(pq.size()<k){
                pq.add(new Pair(key,value));
            }
            else{
                Pair p = pq.peek();
                if(value > p.freq){
                    pq.poll();
                    pq.add(new Pair(key,value));
                }
            }
        }

        int[] ans = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ans[index++] = p.ele;
        }
        return ans;
    }
}