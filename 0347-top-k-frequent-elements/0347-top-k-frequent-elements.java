class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int e : nums) {
            mp.put(e, mp.getOrDefault(e, 0) + 1);
        }

        int n = nums.length;
        List<List<Integer>> freqArr = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            freqArr.add(new ArrayList<>());
        }
    
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int element = entry.getKey();
            int frequency = entry.getValue();
            freqArr.get(frequency).add(element);
        }

        int[] ans = new int[k];
        int index = 0;
        for(int i=n;i>=0;i--){
            if(index == k){
                break;
            }
            List<Integer> elements = freqArr.get(i);
            for(int e: elements){
                ans[index++] = e;
            }
        }
        return ans;
    }
}