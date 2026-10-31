class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int actualNumber = mid + 1;
            int givenNumber = arr[mid];
            int missingNumbers = givenNumber - actualNumber;
            if (missingNumbers < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low+k;
    }
}