class Solution {
    void helper(int index, int target, int[] arr, List<Integer> temp, List<List<Integer>> ans) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> q = new ArrayList<>(temp);
            ans.add(q);
            return;
        }

        for (int start = index; start < arr.length; start++) {
            if (start > index && arr[start] == arr[start - 1]) {
                continue;
            }
            temp.add(arr[start]);
            helper(start + 1, target - arr[start], arr, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, target, arr, new ArrayList<>(), ans);
        return ans;
    }
}