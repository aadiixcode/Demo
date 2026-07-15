class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];

        int pLeft=1;
        for(int i=0;i<n;i++){
            left[i] = pLeft;
            pLeft*=arr[i];
        }

        int[] ans = new int[n];
        int pRight=1;
        for(int i=n-1;i>=0;i--){
            ans[i] = pRight*left[i];
            pRight*=arr[i];
        }
        return ans;
    }
}