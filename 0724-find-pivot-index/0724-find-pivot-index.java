class Solution {
    public int pivotIndex(int[] arr) {
        int n = arr.length;
        int[] ps = new int[n];

        ps[0] = arr[0];
        for(int i=1;i<n;i++){
            ps[i]=ps[i-1]+arr[i];
        }

        if(ps[n-1]-ps[0]==0){
            return 0;
        }

        for(int i=1;i<n;i++){
            if(ps[i-1]==ps[n-1]-ps[i]){
                return i;
            }
        }
        
        if(ps[n-2]==0){
            return n-1;
        }
        return -1;
    }
}