class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n = a.length();
        int m = b.length();

        for (int start = 0; start < n; start++) {
            int i = start;
            int j = 0;

            while (j < m && a.charAt(i % n) == b.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                int lastPosition = i;
                return (int) Math.ceil((double)lastPosition/n);
            }
        }

        return -1;
    }
}