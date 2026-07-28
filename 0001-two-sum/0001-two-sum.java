class Solution {
    public int[] twoSum(int[] arr, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        int[] ans = new int[2];

        for(int i=0;i<arr.length;i++){
            int need = target-arr[i];
            if(mp.containsKey(need)){
                ans[0] = mp.get(need);
                ans[1] = i;
                break;
            }
            mp.put(arr[i],i);
        }
        return ans;
    }
}