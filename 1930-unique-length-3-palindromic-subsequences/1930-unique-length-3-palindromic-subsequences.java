class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] occurence = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(occurence[i], -1);
        }
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int charInd = ch - 'a';
            if (occurence[charInd][0] == -1) {
                occurence[charInd][0] = i;
            }
            occurence[charInd][1] = i;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            int startInd = occurence[i][0];
            int endInd = occurence[i][1];

            if (startInd == -1 || endInd == -1) {
                continue;
            }

            Set<Character> st = new HashSet<>();
            startInd += 1;
            endInd -= 1;
            while (startInd <= endInd) {
                st.add(s.charAt(startInd));
                startInd += 1;
            }
            count += st.size();
        }

        return count;
    }
}