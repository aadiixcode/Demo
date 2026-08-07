class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n];
        int prefixSum = 0;
        int qIndex = 0;
        for(int i=0;i<n;i++){
            prefixSum += diff[i];
            while(prefixSum < nums[i] && qIndex<queries.length){
                int[] q = queries[qIndex];
                int low = q[0];
                int high = q[1];
                int value = q[2];
                diff[low] += value;
                if(high+1 < n){
                    diff[high+1] -= value;
                }
                if(i>=low && i<=high){
                    prefixSum += value;
                }
                qIndex+=1;
            }
            if(prefixSum < nums[i]){
                return -1;
            }
        }
        return qIndex;
    }
}