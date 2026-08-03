class Solution {
    static class Pair{
        double ratio;
        int quality;
        Pair(double ratio,int quality){
            this.ratio = ratio;
            this.quality = quality;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        List<Pair> wageQualityRatio = new ArrayList<>();
        for(int i = 0; i < n; i++){
            double ratio = ((double) wage[i]) / quality[i];
            wageQualityRatio.add(new Pair(ratio,quality[i]));
        }
        Collections.sort(wageQualityRatio,(a,b) -> Double.compare(a.ratio,b.ratio));

        double ans = Double.MAX_VALUE; 
        int totalQuality = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for (int manager = 0; manager < n; manager++) {
            int q = wageQualityRatio.get(manager).quality;
            double r = wageQualityRatio.get(manager).ratio;
            pq.add(q);
            totalQuality += q;
            if(pq.size() > k){
                totalQuality -= pq.poll();
            }
            if(manager >= k-1){
                ans = Math.min(ans, r*totalQuality);
            }
        }
        return ans;
    }
}