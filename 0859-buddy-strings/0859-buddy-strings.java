class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) {
            return false;
        }

        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (char ch : s.toCharArray()) {
                freq[ch - 'a'] += 1;
                if (freq[ch - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }

        List<Integer> mismatchIndex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                mismatchIndex.add(i);
            }
        }
        if (mismatchIndex.size() == 2) {
            int left = mismatchIndex.get(0);
            int right = mismatchIndex.get(1);
            if (s.charAt(left) == goal.charAt(right) && s.charAt(right) == goal.charAt(left)) {
                return true;
            }
            return false;
        }
        return false;
    }
}