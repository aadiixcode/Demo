class Solution {
    static class Pair {
        double value;
        int n1;
        int n2;

        Pair(double value, int n1, int n2) {
            this.value = value;
            this.n1 = n1;
            this.n2 = n2;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a, b) -> Double.compare(b.value,a.value));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double value = ((double) arr[i]) / arr[j];
                pq.add(new Pair(value, arr[i], arr[j]));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        Pair p = pq.poll();
        return new int[] { p.n1, p.n2 };
    }
}