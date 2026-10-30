class Solution {
    int find(int[] weights, int weight) {
        int days = 1;
        int sum = 0;
        for (int w : weights) {
            if (sum + w > weight) {
                days += 1;
                sum = w;
            } else {
                sum += w;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int w : weights) {
            min = Math.max(min, w);
            max += w;
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int daysReq = find(weights, mid);
            if (daysReq <= days) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}