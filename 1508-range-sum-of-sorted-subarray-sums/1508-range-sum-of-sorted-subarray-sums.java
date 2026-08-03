class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);

        long sum = 0;
        for (int i = left; i <= right; i++) {
            sum = (sum + list.get(i-1)) % 1000000007; 
        }
        return (int) sum;
    }
}