class Solution {
    public int subarraySum(int[] arr, int k) {
        int sum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int req = sum - k;
            if (mp.containsKey(req)) {
                count += mp.get(req);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}