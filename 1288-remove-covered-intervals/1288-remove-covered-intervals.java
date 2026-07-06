class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Ascending start time
            }
            return Integer.compare(b[1], a[1]); // Descending end time
        });

        List<int[]> temp = new ArrayList<>();
        temp.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] i1 = intervals[i];
            int[] i2 = temp.getLast();
            if (i1[0] >= i2[0] && i1[1] <= i2[1]) {
                continue;
            } else {
                temp.add(i1);
            }
        }
        return temp.size();
    }
}