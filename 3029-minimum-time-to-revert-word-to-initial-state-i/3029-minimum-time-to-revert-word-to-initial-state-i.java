class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int i = k;
        int steps = 1;
        while (i < n) {
            int start = 0;
            int j = i;
            while (j < n && word.charAt(j) == word.charAt(start)) {
                j += 1;
                start += 1;
            }
            if (j == n) {
                return steps;
            } else {
                i += k;
                steps += 1;
            }
        }
        return steps;
    }
}