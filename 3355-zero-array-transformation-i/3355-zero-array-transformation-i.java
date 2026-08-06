class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n];

        for (int[] query : queries) {
            int low = query[0];
            int high = query[1];
            diff[low] += 1;
            if(high+1 < n){
                diff[high+1] -= 1;
            }
        }

        for(int i=1;i<n;i++){
            diff[i] = diff[i]+diff[i-1];
        }

        for (int i = 0; i < n; i++) {
            if (diff[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}