class Solution {
    public int minDeletionSize(String[] s) {
        int colCount = 0;
        int totalCols = s[0].length();
        for (int i = 0; i < totalCols; i++) {
            for (int j = 0; j < s.length; j++) {
                if (j > 0 && s[j].charAt(i) < s[j - 1].charAt(i)) {
                    colCount += 1;
                    break;
                }
            }
        }
        return colCount;
    }
}