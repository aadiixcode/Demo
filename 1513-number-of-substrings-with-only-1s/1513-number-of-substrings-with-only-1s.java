class Solution {
    public int numSub(String s) {
        int i = 0, j = 0;
        long count = 0;
        int mod = 1000000007;
        while (j < s.length()) {
            if (s.charAt(j) == '0') {
                long length = j - i;
                long numberOfSubstrings = (length * (length + 1)) / 2;
                count = (count + numberOfSubstrings) % mod;
                i = j+1;
            }
            j += 1;
        }
        long length = j - i;
        long numberOfSubstrings = (length * (length + 1)) / 2;
        count = (count + numberOfSubstrings) % mod;
        return (int) count;
    }
}