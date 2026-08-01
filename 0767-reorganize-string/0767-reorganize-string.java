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
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c-'a'] += 1;
            if(freq[c-'a'] > (n+1)/2){
                return "";
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                char c = (char) ('a'+i);
                pq.add(new Pair(c,freq[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size() >= 2){
            Pair p1 = pq.poll();
            char c1 = p1.c;
            int f1 = p1.freq;
            f1 -= 1;
            sb.append(c1);

            Pair p2 = pq.poll();
            char c2 = p2.c;
            int f2 = p2.freq;
            f2 -= 1;
            sb.append(c2);

            if(f1 > 0){
                pq.add(new Pair(c1,f1));
            }
            if(f2 > 0){
                pq.add(new Pair(c2,f2));
            }
        }
        if(!pq.isEmpty()){
            sb.append(pq.peek().c);
        }
        return sb.toString();
    }
}