class Solution {
    static class Pair {
        int value, row, col;

        Pair(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        Set<Integer> vis = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        vis.add(0);
        pq.add(new Pair(matrix[0][0], 0, 0));

        int ans = matrix[0][0];
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int row = p.row;
            int col = p.col;
            int value = p.value;
            k -= 1;

            if(k==0){
                ans = value;
                break;
            }

            if (row + 1 < n) {
                int key = (n * (row + 1)) + col;
                if (!vis.contains(key)) {
                    pq.add(new Pair(matrix[row + 1][col], row + 1, col));
                    vis.add(key);
                }
            }
            if (col + 1 < n) {
                int key = (n * row) + (col + 1);
                if (!vis.contains(key)) {
                    pq.add(new Pair(matrix[row][col + 1], row, col + 1));
                    vis.add(key);
                }
            }
        }
        return ans;
    }
}

/**

1  5  9
10 11 13
12 13 15

 */