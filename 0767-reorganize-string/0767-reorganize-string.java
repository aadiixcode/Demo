class Solution {
    static class Pair {
        char c;
        int freq;
        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        for (char c : s.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
            if(mp.get(c) > (n+1)/2){
                return "";
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (Map.Entry<Character, Integer> e : mp.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size() >= 2){
            Pair p1 = pq.poll();
            sb.append(p1.c);
            p1.freq -= 1;

            Pair p2 = pq.poll();
            sb.append(p2.c);
            p2.freq -= 1;

            if(p1.freq > 0){
                pq.add(p1);
            }
            if(p2.freq > 0){
                pq.add(p2);
            }
        }
        if(!pq.isEmpty()){
            sb.append(pq.peek().c);
        }
        return sb.toString();
    }
}