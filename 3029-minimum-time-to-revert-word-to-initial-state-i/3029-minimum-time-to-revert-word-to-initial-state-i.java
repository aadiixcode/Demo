class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int i = k;
        int steps = 1;
        while (i < n) {
            if (word.substring(i, n).equals(word.substring(0, n - i))) {
                break;
            } else {
                i += k;
                steps += 1;
            }
        }
        return steps;
    }
}