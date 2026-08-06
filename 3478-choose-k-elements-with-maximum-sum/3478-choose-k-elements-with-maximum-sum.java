class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] ans = new long[n];
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = i;
            arr[i][2] = nums2[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int[] p = arr[i];
            int index = p[1];
            int nums2Value = p[2];

            if (i > 0 && arr[i - 1][0] == arr[i][0]) {
                ans[index] = ans[arr[i - 1][1]];
            } else {
                ans[index] = sum;
            }

            sum += nums2Value;
            minHeap.add(nums2Value);
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
        }
        return ans;
    }
}