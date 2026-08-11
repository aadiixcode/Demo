class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            if (s.charAt(j) != s.charAt(i)) {
                if (j - i >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j - 1);
                    ans.add(temp);
                }
                i = j;
            }
            j += 1;
        }
        if (j - i >= 3) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(j - 1);
            ans.add(temp);
        }
        return ans;
    }
}