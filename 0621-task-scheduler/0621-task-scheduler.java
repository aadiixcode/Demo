class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A'] += 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(freq[i]);
            }
        }

        int totalInterval = 0;
        while (pq.size() > 0) {
            List<Integer> temp = new ArrayList<>();
            int i = 1;
            while (!pq.isEmpty() && i <= n + 1) {
                int f = pq.poll();
                f -= 1;
                temp.add(f);
                i += 1;
            }
             
            for (int f : temp) {
                if(f>0){
                    pq.add(f);
                }
            }
            if(pq.isEmpty()){
                totalInterval += temp.size();
            }
            else{
                totalInterval += n+1;
            }
        }
        return totalInterval;
    }
}