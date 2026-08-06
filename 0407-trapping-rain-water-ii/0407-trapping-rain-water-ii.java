class Solution {
    static class Pair {
        int maxValue;
        int row, col;

        Pair(int maxValue, int row, int col) {
            this.maxValue = maxValue;
            this.row = row;
            this.col = col;
        }
    }

    public int trapRainWater(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.maxValue - b.maxValue);
        boolean[][] vis = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            vis[0][j] = true;
            minHeap.add(new Pair(arr[0][j], 0, j));
            vis[n - 1][j] = true;
            minHeap.add(new Pair(arr[n - 1][j], n - 1, j));
        }

        for (int i = 1; i < n - 1; i++) {
            vis[i][0] = true;
            minHeap.add(new Pair(arr[i][0], i, 0));
            vis[i][m - 1] = true;
            minHeap.add(new Pair(arr[i][m - 1], i, m - 1));
        }

        int[] rows = { 0, -1, 0, 1 };
        int[] cols = { -1, 0, 1, 0 };

        int trappedWater = 0;
        while (minHeap.size() > 0) {
            Pair cell = minHeap.poll();
            int value = cell.maxValue;
            int row = cell.row;
            int col = cell.col;

            for (int i = 0; i < 4; i++) {
                int nr = rows[i] + row;
                int nc = cols[i] + col;

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == false) {
                    vis[nr][nc] = true;
                    if (arr[nr][nc] < value) {
                        trappedWater += (value - arr[nr][nc]);
                    }
                    minHeap.add(new Pair(Math.max(value, arr[nr][nc]), nr, nc));
                }
            }
        }
        return trappedWater;
    }
}