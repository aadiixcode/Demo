class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int max = arr.length;
        int[] temp = new int[max+1];
        temp[1] = 1;
        for(int e: arr){
            if(e>max){
                temp[max]+=1;
            }
            else {
                temp[e]+=1;
            }
        }

        int ans=1;
        for(int i=2;i<temp.length;i++){
            int freq = Math.min(i,ans+temp[i]);
            ans = Math.max(ans,freq);
        }
        return ans;
    }
}