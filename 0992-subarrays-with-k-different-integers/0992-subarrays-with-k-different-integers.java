class Solution {
    int helper(int[] nums, int k) {
        int count = 0;
        int i = 0, j = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while (j < nums.length) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            while (mp.size() > k) {
                mp.put(nums[i], mp.getOrDefault(nums[i], 0) - 1);
                if (mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i += 1;
            }
            count += (j - i + 1);
            j += 1;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }
}