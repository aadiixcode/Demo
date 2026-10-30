class Solution {

    int noOfBoq(int[] bloomDay, int day, int k) {
        int currBouquets = 0;
        int flowerCount = 0;
        for (int e : bloomDay) {
            if (e > day) {
                if (flowerCount > 0) {
                    currBouquets += (flowerCount / k);
                }
                flowerCount = 0;
            } else {
                flowerCount += 1;
            }
        }
        if (flowerCount > 0) {
            currBouquets += (flowerCount / k);
        }
        return currBouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long)m * k > n) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int currBouquets = noOfBoq(bloomDay, mid, k);
            if (currBouquets >= m) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}