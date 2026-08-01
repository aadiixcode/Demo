class Solution {

    int helper(int low, int high, int[] arr,int k) {
        int i = low+1, j = high;
        int pivot = arr[low];
        while (i <= j) {
            if (arr[i] < pivot && arr[j] > pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i += 1;
                j -= 1;  
            } 
            if (arr[i] >= pivot) {
                i += 1;
            } 
             if (arr[j] <= pivot) {
                j -= 1;
            }
        }
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;
         
        if(k < j){
            return helper(low,j-1,arr,k);
        }
        else if(k > j){
            return helper(j+1,high,arr,k);
        }
        return arr[j];
    }

    public int findKthLargest(int[] nums, int k) {
        int low=0;
        int high=nums.length-1;
        return helper(low,high,nums,k-1);
    }
}