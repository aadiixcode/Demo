class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        int[] vis = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = 1;
        while (!q.isEmpty()) {
            int currInd = q.poll();
            if (arr[currInd] == 0) {
                return true;
            }
            int nextInd = currInd + arr[currInd];
            int prevInd = currInd - arr[currInd];
            if (prevInd >= 0 && vis[prevInd] == 0) {
                q.add(prevInd);
                vis[prevInd] = 1;
            }
            if (nextInd < n && vis[nextInd] == 0) {
                q.add(nextInd);
                vis[nextInd] = 1;
            }
        }
        return false;
    }
}

// 