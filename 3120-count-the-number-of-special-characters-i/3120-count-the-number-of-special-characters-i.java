class Solution {
    public int numberOfSpecialChars(String word) {
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                f2[ch - 'A'] = 1;
            } else {
                f1[ch - 'a'] = 1;
            }
        }

        int count = 0;
        for(int i=0;i<26;i++){
            if(f1[i]==1 && f2[i]==1){
                count += 1;
            }
        }
        return count;
    }
}