class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        boolean isEven = (n + m) % 2 == 0 ? true : false;

        int mid = (n + m) / 2;
        double totalSum = 0;
        int i = 0, j = 0, count = 0;
        while (i < n && j < m) {
            int minValue = Math.min(nums1[i], nums2[j]);
            if (count == mid) {
                totalSum += minValue;
            }
            if (count == mid - 1 && isEven) {
                totalSum += minValue;
            }
            if (nums1[i] < nums2[j]) {
                i += 1;
            } else {
                j += 1;
            }
            count += 1;
        }
        while(i<n){
            if (count == mid) {
                totalSum += nums1[i];
            }
            if (count == mid - 1 && isEven) {
                totalSum += nums1[i];
            }
            i += 1;
            count += 1;
        }
        while(j<m){
            if (count == mid) {
                totalSum += nums2[j];
            }
            if (count == mid - 1 && isEven) {
                totalSum += nums2[j];
            }
            j += 1;
            count += 1;
        }
        if (isEven) {
            return totalSum / 2;
        }
        return totalSum;
    }
}