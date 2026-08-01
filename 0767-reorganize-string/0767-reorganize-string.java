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

        char[] arr = new char[n];
        int index = 0;
        while(pq.size() > 0){
            Pair p = pq.poll();
            int freq = p.freq;
            char c=p.c;
            while(freq > 0){
                if(index >= n){
                    index = 1;
                }
                arr[index] = c;
                index += 2;
                freq -= 1;
            }
        }
        return new String(arr);
    }
}