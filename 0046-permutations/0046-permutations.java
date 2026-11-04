class Solution {
    void helper(int index, int[] nums, boolean[] vis, List<Integer> curr, List<List<Integer>> ans) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            curr.add(nums[i]);
            helper(i + 1, nums, vis, curr, ans);
            curr.remove(curr.size() - 1);
            vis[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        boolean[] vis = new boolean[n];
        helper(0, nums, vis, new ArrayList<>(), ans);
        return ans;
    }
}