class Solution {
    static class Pair {
        double quotient;
        int i;
        int j;

        Pair(double quotient, int i, int j) {
            this.quotient = quotient;
            this.i = i;
            this.j = j;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(a.quotient, b.quotient));
        for (int i = 0; i < n-1; i++) {
            double q = ((double) arr[i]) / arr[n-1];
            pq.add(new Pair(q, i, n-1));
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            k -= 1;
            int i = p.i;
            int j = p.j;
            if (k == 0) {
                return new int[] { arr[i], arr[j] };
            }
            j -= 1;
            // if (i < j) {
                double q = ((double) arr[i]) / arr[j];
                pq.add(new Pair(q, i, j));
            // }
        }
        return new int[] { -1, -1 };
    }
}