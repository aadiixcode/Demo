class Solution {
    static class Pair {
        int freq;
        char c;

        Pair(int freq, char c) {
            this.freq = freq;
            this.c = c;
        }
    }

    public String longestDiverseString(int aFreq, int bFreq, int cFreq) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        if (aFreq > 0) {
            maxHeap.add(new Pair(aFreq, 'a'));
        }
        if (bFreq > 0) {
            maxHeap.add(new Pair(bFreq, 'b'));
        }
        if (cFreq > 0) {
            maxHeap.add(new Pair(cFreq, 'c'));
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Pair p1 = maxHeap.poll();

            int size = sb.length();
            if (size >= 2 && sb.charAt(size - 1) == p1.c && sb.charAt(size - 2) == p1.c) {
                if (!maxHeap.isEmpty()) {
                    Pair p2 = maxHeap.poll();
                    sb.append(p2.c);
                    p2.freq -= 1;
                    if (p2.freq > 0) {
                        maxHeap.add(p2);
                    }
                    maxHeap.add(p1);
                }

            } else {
                sb.append(p1.c);
                p1.freq -= 1;
                if (p1.freq > 0) {
                    maxHeap.add(p1);
                }
            }
        }
        return sb.toString();
    }
}