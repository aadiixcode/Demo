class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        int[] freq = new int[26];
        int maxFreq = 0, maxLen = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            freq[ch - 'A'] += 1;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            int changeReq = (j - i + 1) - maxFreq;
            if (changeReq > k) {
                freq[s.charAt(i) - 'A'] -= 1;
                i += 1;
            }
            if (((j - i + 1) - maxFreq) <= k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            j += 1;
        }
        return maxLen;
    }
}