class Solution {
    static class Pair {
        int listInd, elementInd, value;

        Pair(int listInd, int elementInd, int value) {
            this.listInd = listInd;
            this.elementInd = elementInd;
            this.value = value;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int listSize = nums.size();
        int[] ans = new int[] { -1000000, 1000000 };

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < listSize; i++) {
            int value = nums.get(i).get(0);
            minHeap.add(new Pair(i, 0, value));
            maxValue = Math.max(maxValue,value);
        }

        while (true) {
            Pair p1 = minHeap.poll();
            int minValue = p1.value;
            int minListInd = p1.listInd;
            int minElementInd = p1.elementInd;

            if (ans[1] - ans[0] > maxValue - minValue) {
                ans[0] = minValue;
                ans[1] = maxValue;
            }
            if (ans[1] - ans[0] == maxValue - minValue && minValue < ans[0]) {
                ans[0] = minValue;
                ans[1] = maxValue;
            }

            int nextInd = minElementInd + 1;
            if (nextInd >= nums.get(minListInd).size()) {
                break;
            }

            int value = nums.get(minListInd).get(nextInd);
            minHeap.add(new Pair(minListInd, nextInd, value));
            maxValue = Math.max(maxValue,value);
        }
        return ans;
    }
}