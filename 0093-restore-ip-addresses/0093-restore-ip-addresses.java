class Solution {
    void helper(int index, String s, StringBuilder curr, int parts, List<String> ans) {
        int n = s.length();
        if (index == n || parts == 4) {
            if (index == n && parts == 4) {
                curr.deleteCharAt(curr.length() - 1);
                ans.add(curr.toString());
                curr.append(".");
            }
            return;
        }

        for (int len = 1; len <= 3 && index + len <= n; len++) {

            String part = s.substring(index, index + len);
            if (len > 1 && part.charAt(0) == '0') {
                break;
            }
            if (Integer.parseInt(part) > 255) {
                break;
            }

            int oldLength = curr.length();
            curr.append(part).append(".");
            helper(index + len, s, curr, parts + 1, ans);
            curr.setLength(oldLength);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() > 12) {
            return ans;
        }
        helper(0, s, new StringBuilder(), 0, ans);
        return ans;
    }
}