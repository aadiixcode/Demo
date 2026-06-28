class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int max = arr.length;
        int[] temp = new int[max+1];
        for(int e: arr){
            if(e>max){
                temp[max]+=1;
            }
            else {
                temp[e]+=1;
            }
        }

        int j = 0;
        for(int i=1;i<temp.length;i++){
            while(temp[i]>0){
                arr[j++] = i;
                temp[i]-=1;
            }
        }

        arr[0] = 1;
        int ans = arr[0];
        for(int i=1;i<arr.length;i++){
            if(Math.abs(arr[i]-arr[i-1])>1){
                arr[i]=arr[i-1]+1;
            }
            ans = Math.max(ans,arr[i]);
        }
        return ans;
    }
}