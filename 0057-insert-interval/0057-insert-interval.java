class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        int st = newInterval[0], et = newInterval[1];
        while (i < n && intervals[i][1] < st) {
            temp.add(intervals[i]);
            i += 1;
        }
        
        while(i<n && st <= intervals[i][1] && et >= intervals[i][0]){
            st = Math.min(st, intervals[i][0]);
            et = Math.max(et, intervals[i][1]);
            i += 1;
        }
        temp.add(new int[]{st,et});

        while (i < n) {
            temp.add(intervals[i]);
            i += 1;
        }

        int[][] ans = new int[temp.size()][2];
        for(int j=0;j<temp.size();j++){
            ans[j][0] = temp.get(j)[0];
            ans[j][1] = temp.get(j)[1];
        }
        return ans;
    }
}