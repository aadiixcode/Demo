class Solution {
    void find(int index, int n, StringBuilder sb, int balance, List<String> ans) {
        if (index == n) {
            if (balance == 0) {
                ans.add(sb.toString());
            }
            return;
        }

        sb.append('(');
        find(index + 1, n, sb, balance + 1, ans);
        sb.deleteCharAt(sb.length() - 1);

        if (balance > 0) {
            sb.append(')');
            find(index + 1, n, sb, balance - 1, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        find(0, n * 2, new StringBuilder(), 0, ans);
        return ans;
    }
}