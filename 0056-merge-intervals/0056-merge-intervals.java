class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> temp = new ArrayList<>();

        int startTime = intervals[0][0], endTime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= endTime){
                endTime = Math.max(endTime,intervals[i][1]);
            }
            else{
                temp.add(new int[] {startTime,endTime});
                startTime = intervals[i][0];
                endTime = intervals[i][1];
            }
        }
        temp.add(new int[] {startTime,endTime});



        int[][] ans = new int[temp.size()][2];
        for(int i=0;i<temp.size();i++){
            ans[i][0] = temp.get(i)[0];
            ans[i][1] = temp.get(i)[1];
        }
        return ans;
    }
}