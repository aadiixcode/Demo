class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MIN_VALUE;
        for (int e : piles) {
            high = Math.max(high, e);
        }

        int ansHours = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hours = 0;
            for (int e : piles) {
                hours += (e / mid);
                if (e % mid != 0) {
                    hours += 1;
                }
            }
            if (hours <= h) {
                ansHours = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ansHours;
    }
}