class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int changes = 0;
        for (int i = 1; i < n; i += 2) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                changes += 1;
            }
        }
        return changes;
    }
}