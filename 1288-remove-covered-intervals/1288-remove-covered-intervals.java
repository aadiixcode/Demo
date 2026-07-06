class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0]-b[0]; // Ascending start time
            }
            return b[1]-a[1]; // Descending end time
        });

        int maxEnd = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[1] <= maxEnd) {
                continue;
            } else {
                ans+=1;
                maxEnd = interval[1];
            }
        }
        return ans;
    }
}