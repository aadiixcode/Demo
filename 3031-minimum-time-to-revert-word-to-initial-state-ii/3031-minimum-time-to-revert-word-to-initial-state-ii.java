class Solution {
    static int[] findLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int i = 0, j = 1;
        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[j] = i + 1;
                i += 1;
                j += 1;
            } else {
                if (i == 0) {
                    lps[j] = 0;
                    j += 1;
                } else {
                    i = lps[i - 1];
                }
            }
        }
        return lps;
    }

    public int minimumTimeToInitialState(String word, int k) {
        int[] lps = findLPS(word);
        int n = word.length();
        int longestSuffix = lps[n - 1];
        while ((word.length() - longestSuffix) % k != 0) {
            if (longestSuffix == 0) {
                return (int) Math.ceil(n / (double) k);
            }
            longestSuffix = lps[longestSuffix - 1];
        }
        return (n - longestSuffix) / k;
    }
}