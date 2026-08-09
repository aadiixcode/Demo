class Solution {
    public int numberOfSpecialChars(String word) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        Arrays.fill(f1, -1);
        Arrays.fill(f2, -1);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch) && f2[ch - 'A'] == -1) {
                f2[ch - 'A'] = i;
            } else if(Character.isLowerCase(ch)){
                f1[ch - 'a'] = i;
            }
        }


        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (f1[i] == -1 || f2[i] == -1) {
                continue;
            }
            if (f1[i] < f2[i]) {
                count += 1;
            }
        }
        return count;
    }
}