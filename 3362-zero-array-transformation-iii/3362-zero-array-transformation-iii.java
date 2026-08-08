class Solution {

    public int maxRemoval(int[] nums, int[][] queries) {

        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        int n = nums.length;
        PriorityQueue<Integer> eligibleCandidates = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> chosenCandidates = new PriorityQueue<>();

        int ans = 0, qIndex = 0;
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            while (qIndex < queries.length && queries[qIndex][0] == i) {
                eligibleCandidates.add(queries[qIndex][1]);
                qIndex += 1;
            }
            value -= chosenCandidates.size();
            while (value > 0 && !eligibleCandidates.isEmpty() && eligibleCandidates.peek() >= i) {
                ans += 1;
                chosenCandidates.add(eligibleCandidates.poll());
                value -= 1;
            }

            if(value > 0){
                return -1;
            }

            while (!chosenCandidates.isEmpty() && chosenCandidates.peek() <= i) {
                chosenCandidates.poll();
            }
        }
        return queries.length - ans;
    }
}