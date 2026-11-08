class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int[] mp = new int[255];
        Arrays.fill(mp, -1);

        int maxLen = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (mp[ch] >= i) {
                i = mp[ch] + 1;
            }
            mp[ch] = j;
            maxLen = Math.max(maxLen, j - i + 1);
            j += 1;
        }
        return maxLen;
    }
}