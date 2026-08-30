class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] sen1 = sentence1.split(" ");
        String[] sen2 = sentence2.split(" ");
        if (sen1.length < sen2.length) {
            String[] temp = sen1;
            sen1 = sen2;
            sen2 = temp;
        }

        int n = sen1.length;
        int m = sen2.length;

        int i = 0;
        int j = n - 1;
        int l = 0;
        int r = m - 1;

        // Match from left
        while (i < n && l < m && sen1[i].equals(sen2[l])) {
            i++;
            l++;
        }

        // Match from right
        while (j >= i && r >= l && sen1[j].equals(sen2[r])) {
            j--;
            r--;
        }

        return l > r;
    }
}