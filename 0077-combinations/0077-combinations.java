class Solution {
    void helper(int num, int n, int k, List<Integer> temp, List<List<Integer>> ans) {
        if (k == 0) {
            List<Integer> q = new ArrayList<>(temp);
            ans.add(q);
            return;
        }
        if (num == n + 1) {
            return;
        }
        temp.add(num);
        helper(num + 1, n, k - 1, temp, ans);
        temp.remove(temp.size() - 1);
        helper(num + 1, n, k, temp, ans);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int start = 1; start <= n; start++) {
            temp.add(start);
            helper(start + 1, n, k - 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
        return ans;
    }
}

// 1 2 3 4