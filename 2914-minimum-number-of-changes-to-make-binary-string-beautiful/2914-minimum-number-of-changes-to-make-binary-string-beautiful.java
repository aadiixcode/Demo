class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int i = 0;
        int changes = 0;
        while (i < n) {
            char curr = s.charAt(i);
            int count = 1;

            i += 1;
            while (i < n && s.charAt(i) == curr) {
                i += 1;
                count += 1;
            }

            if (count % 2 == 0) {
                continue;
            } else {
                changes += 1;
                i += 1;
            }
        }
        return changes;
    }
}