class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] freq = new int[2*n+1];
        freq[n] = 1;

        int sum = 0;
        int count = 0;
        long ans = 0;

        for(int i=0;i<n;i++){
            if(nums[i]==target){
                count += freq[n+sum];
                sum+=1;
            }
            else{
                sum -= 1;
                count -= freq[n+sum];
            }
            ans += 1L * count;
            freq[n+sum] += 1;
        }
        return ans;
    }
}