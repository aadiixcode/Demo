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
            char currChar = p1.c;
            int currCount = p1.freq;

            int size = sb.length();
            if (size >= 2 && sb.charAt(size - 1) == currChar && sb.charAt(size - 2) == currChar) {
                if (!maxHeap.isEmpty()) {
                    Pair p2 = maxHeap.poll();
                    char nextChar = p2.c;
                    int nextCount = p2.freq;
                    sb.append(nextChar);
                    nextCount -= 1;
                    if (nextCount> 0) {
                        maxHeap.add(new Pair(nextCount,nextChar));
                    }
                    maxHeap.add(new Pair(currCount,currChar));
                }

            } 
            else {
                sb.append(currChar);
                currCount -= 1;
                if (currCount > 0) {
                    maxHeap.add(new Pair(currCount,currChar));
                }
            }
        }
        return sb.toString();
    }
}