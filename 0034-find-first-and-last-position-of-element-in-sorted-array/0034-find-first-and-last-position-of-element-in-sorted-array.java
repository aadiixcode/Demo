class Solution {

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int leftIndex = -1;

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                leftIndex = mid;
                high = mid-1;
            }
            else if(target < nums[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        int rightIndex = -1;
        low = 0; high = n-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                rightIndex = mid;
                low = mid+1;
            }
            else if(target > nums[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return new int[]{leftIndex,rightIndex};
    }
}