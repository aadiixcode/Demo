class Solution {
    public long countSubstrings(String s, char c) {
        int charCount = 0;
        long subStringCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) {
                charCount += 1;
                subStringCount += charCount;
            }
        }
        return subStringCount;
    }
}