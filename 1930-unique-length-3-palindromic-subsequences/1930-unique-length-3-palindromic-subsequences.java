class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int count = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int i = 0, j = n - 1;
            while (i < n && s.charAt(i) != ch) {
                i += 1;
            }
            while (j >= 0 && s.charAt(j) != ch) {
                j -= 1;
            }

            Set<Character> st = new HashSet<>();
            i += 1; 
            j -= 1;
            while(i<=j){
                st.add(s.charAt(i));
                i += 1;
            }
            count += st.size();
        }

        return count;
    }
}