class Solution {
    public int pivotIndex(int[] arr) {
        int n = arr.length;
        int ts = 0; 
        for(int e: arr){
            ts+=e;
        }

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum-arr[i]==ts-sum){
                return i;
            }
        }
        return -1;
    }
}