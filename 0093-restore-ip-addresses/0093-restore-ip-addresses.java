class Solution {

    boolean isValid(String s) {
        if (s.charAt(0) == '0' || Integer.valueOf(s) > 255) {
            return false;
        }
        return true;
    }

    void helper(int index, String s, String curr, int parts, List<String> ans) {
        int n = s.length();
        if (index == n || parts == 4) {
            if (index == n && parts == 4) {
                String ip = new String(curr.substring(0, curr.length() - 1));
                ans.add(ip);
            }
            return;
        }

        if (index + 1 <= n) {
            String len1 = s.substring(index, index + 1);
            helper(index + 1, s, curr + len1 + ".", parts + 1, ans);
        }
        if (index + 2 <= n) {
            String len2 = s.substring(index, index + 2);
            if (isValid(len2)) {
                helper(index + 2, s, curr + len2 + ".", parts + 1, ans);
            }
        }
        if (index + 3 <= n) {
            String len3 = s.substring(index, index + 3);
            if (isValid(len3)) {
                helper(index + 3, s, curr + len3 + ".", parts + 1, ans);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() > 12) {
            return ans;
        }
        helper(0, s, "", 0, ans);
        return ans;
    }
}