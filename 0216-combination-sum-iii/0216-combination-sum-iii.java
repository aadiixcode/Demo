class Solution {
    void helper(int num, int k, int target, List<Integer> temp, List<List<Integer>> ans) {
        if (k == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = num; i <= 9; i++) {
            if (i > target)
                break;
            temp.add(i);
            helper(i + 1, k - 1, target - i, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, k, n, new ArrayList<>(), ans);
        return ans;
    }
}