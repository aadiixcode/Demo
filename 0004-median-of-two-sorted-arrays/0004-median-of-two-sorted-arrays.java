class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n>m){
            return findMedianSortedArrays(nums2,nums1);
        }

        boolean isEven = (n + m) % 2 == 0 ? true : false;
        int elementsReq = isEven ? (n + m) / 2 : (n + m + 1) / 2;

        int low = 0, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int reqOnLeft = elementsReq - mid;

            int l1 = mid - 1 >= 0 ? nums1[mid - 1] : Integer.MIN_VALUE;
            int l2 = reqOnLeft - 1 >= 0 ? nums2[reqOnLeft - 1] : Integer.MIN_VALUE;
            int r1 = mid < n ? nums1[mid] : Integer.MAX_VALUE;
            int r2 = reqOnLeft < m ? nums2[reqOnLeft] : Integer.MAX_VALUE;

            if (l1 > r2) {
                high = mid - 1;
            } else if (l2 > r1) {
                low = mid + 1;
            } else {
                int left = Math.max(l1, l2);
                int right = Math.min(r1, r2);
                if (isEven) {
                    return (left + right) / 2.0;
                }
                return left;
            }
        }
        return Integer.MIN_VALUE;
    }
}