class Solution {
    public int findKthPositive(int[] arr, int k) {
        int num = 1;
        int i = 0;
        while (k > 0 && i < arr.length) {
            if (arr[i] == num) {
                i += 1;
                num += 1;
            } else {
                k -= 1;
                num += 1;
            }
        }
        while(k>0){
            k-=1;
            num += 1;
        }
        return num-1;
    }
}