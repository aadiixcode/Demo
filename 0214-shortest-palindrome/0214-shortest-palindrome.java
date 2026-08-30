class Solution {
    void findLPS(int[] lps, String s) {
        int i = 0, j = 1;
        while (j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                if (i != 0) {
                    i = lps[i - 1];
                } else {
                    lps[j] = 0;
                    j += 1;
                }
            } else {
                i += 1;
                lps[j] = i;
                j += 1;
            }
        }
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        if(n==0){
            return "";
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - 1 - i] = temp;
        }
        String reverse = new String(arr);

        String newString = s + "#" + reverse;
        int[] lps = new int[newString.length()];
        findLPS(lps, newString);

        int longestPrefixSuffixMatch = lps[lps.length-1];
        return reverse.substring(0,n-longestPrefixSuffixMatch) + s;
    }
}