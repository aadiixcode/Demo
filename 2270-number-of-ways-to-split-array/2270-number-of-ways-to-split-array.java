class Solution {
    public int waysToSplitArray(int[] arr) {
        int n = arr.length;
        long ts = 0;
        for (int e : arr) {
            ts += e;
        }

        long cs = 0;
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            cs += arr[i];
            if (cs >= ts - cs) {
                count += 1;
            }
        }
        return count;
    }
}