class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();

        int sum = 0;
        mp.put(0,1);
        int count = 0;
        long ans = 0;

        for(int i=0;i<n;i++){
            if(nums[i]==target){
                count += mp.getOrDefault(sum,0);
                sum+=1;
            }
            else{
                sum -= 1;
                count -= mp.getOrDefault(sum,0);
            }
            ans += 1L * count;
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}