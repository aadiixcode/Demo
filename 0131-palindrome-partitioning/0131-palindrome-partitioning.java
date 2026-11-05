class Solution {
    boolean isPalindrome(String substr) {
        int i = 0, j = substr.length() - 1;
        while (i <= j) {
            if (substr.charAt(i) != substr.charAt(j)) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }

    void helper(int index, String s, List<String> temp, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substr = s.substring(index, i + 1);
            if (isPalindrome(substr)) {
                temp.add(substr);
                helper(i + 1, s, temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(0, s, new ArrayList<>(), ans);
        return ans;
    }
}