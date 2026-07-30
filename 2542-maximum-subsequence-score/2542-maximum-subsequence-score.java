class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] elements = new int[n][2];
        for (int i = 0; i < n; i++) {
            elements[i][0] = nums1[i];
            elements[i][1] = nums2[i];
        }
        Arrays.sort(elements, (a, b) -> b[1] - a[1]);

        // System.out.println()

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long score = 0;
        long maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int a = elements[i][0];
            int b = elements[i][1];
            score += a;
            pq.add(a);

            if (i >= k - 1) {
                if (pq.size() > k) {
                    score -= pq.poll();
                }
                maxScore = Math.max(maxScore, score * b);
            }
        }
        return maxScore;
    }
}