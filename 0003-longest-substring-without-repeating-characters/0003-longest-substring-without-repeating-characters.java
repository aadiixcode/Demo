class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int[] mp = new int[255];

        int maxLen = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            mp[ch] += 1;
            while (mp[ch] > 1) {
                mp[s.charAt(i)] -= 1;
                i += 1;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j += 1;
        }
        return maxLen;
    }
}