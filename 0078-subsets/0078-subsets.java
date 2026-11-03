class Solution {
    void helper(int[] arr, int index, int n, List<Integer> temp, Set<List<Integer>> ans) {
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
        Set<List<Integer>> ans = new HashSet<>();
        helper(nums, 0, nums.length, new ArrayList<>(), ans);

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> l : ans) {
            res.add(l);
        }
        return res;
    }
}