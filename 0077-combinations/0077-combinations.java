class Solution {
    void helper(int num, int n, int k, List<Integer> temp, List<List<Integer>> ans) {
        if (k == 0) {
            List<Integer> q = new ArrayList<>(temp);
            ans.add(q);
            return;
        }

        for (int i = num; i <= n; i++) {
            temp.add(i);
            helper(i + 1, n, k - 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(1, n, k, temp, ans);
        return ans;
    }
}

// 1 2 3 4