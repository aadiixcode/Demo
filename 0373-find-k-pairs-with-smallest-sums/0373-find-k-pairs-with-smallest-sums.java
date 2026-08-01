class Solution {
    static class Pair {
        int i, j, sum;

        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        Set<Long> vis = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        pq.add(new Pair(nums1[0] + nums2[0], 0, 0));
        vis.add((long) (0));

        List<List<Integer>> ans = new ArrayList<>();
        while (ans.size() < k && !pq.isEmpty()) {
            Pair p = pq.poll();
            int i = p.i;
            int j = p.j;

            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[i]);
            temp.add(nums2[j]);
            ans.add(temp);

            if (i + 1 < n) {
                long key = ((long) (i + 1)) * m + j;
                if (!vis.contains(key)) {
                    pq.add(new Pair(nums1[i + 1] + nums2[j], i + 1, j));
                    vis.add(key);
                }
            }
            if (j + 1 < m) {
                long key = ((long) i) * m + (j + 1);
                if (!vis.contains(key)) {
                    pq.add(new Pair(nums1[i] + nums2[j+1], i, j+1));
                    vis.add(key);
                }
            }
        }
        return ans;
    }
}