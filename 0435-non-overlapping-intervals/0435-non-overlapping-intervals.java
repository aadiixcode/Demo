class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int n = intervals.length;
        int prevEndTime = Integer.MIN_VALUE;
        int count = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= prevEndTime) {
                prevEndTime = interval[1];
                count += 1;
            }
        }
        return n - count;
    }
}