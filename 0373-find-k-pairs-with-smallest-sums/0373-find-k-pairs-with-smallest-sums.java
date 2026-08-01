class Solution {
    static class Pair {
        int u1, v1, sum;

        Pair(int sum, int u1, int v1) {
            this.sum = sum;
            this.u1 = u1;
            this.v1 = v1;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.sum - a.sum);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int u1 = nums1[i];
                int v1 = nums2[j];
                int sum = u1 + v1;
                if (pq.size() < k) {
                    pq.add(new Pair(sum,u1,v1));
                }
                else if (pq.peek().sum > sum) {
                    pq.poll();
                    pq.add(new Pair(sum,u1,v1));
                } else if (sum >= pq.peek().sum) {
                    break;
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(p.u1);
            temp.add(p.v1);
            ans.add(temp);
        }
        return ans;
    }
}