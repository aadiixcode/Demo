class Solution {
    static class Pair{
        int value,index;
        Pair(int value,int index){
            this.value = value;
            this.index = index;
        }
    }
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->  a.value-b.value);
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(nums[i],i));
        }

        List<Integer> subArrSum = new ArrayList<>();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int prevValue = p.value;
            int prevInd = p.index;
            subArrSum.add(prevValue);

            if(prevInd+1 < n){
                int newInd = prevInd + 1;
                int newValue = prevValue + nums[newInd];
                pq.add(new Pair(newValue,newInd));
            }
        }   
        System.out.println(subArrSum);     

        long totalSum = 0;
        for(int i=left;i<=right;i++){
            totalSum = (totalSum + subArrSum.get(i-1)) % 1000000007;
        }

        return (int) totalSum;
    }
}