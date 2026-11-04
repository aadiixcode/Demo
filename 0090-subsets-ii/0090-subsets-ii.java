class Solution {
    void helper(int index,  int[] arr, List<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int start = index; start < arr.length; start++) {
            if (start > index && arr[start] == arr[start - 1]) {
                continue;
            }
            temp.add(arr[start]);
            helper(start + 1, arr, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, arr, new ArrayList<>(), ans);
        return ans;
    }
}