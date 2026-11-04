class Solution {
    void helper(int[] arr, int index, int n, List<Integer> temp, List<List<Integer>> ans) {
        if (index == n) {
            List<Integer> q = new ArrayList<>(temp);
            ans.add(q);
            return;
        }
        temp.add(arr[index]);
        helper(arr, index + 1, n, temp, ans);
        temp.remove(temp.size() - 1);
        helper(arr, index + 1, n, temp, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, nums.length, new ArrayList<>(), ans);
        return ans;
    }
}