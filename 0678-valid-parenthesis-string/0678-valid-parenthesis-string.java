class Solution {
    public boolean checkValidString(String s) {
        int minOpenBracket = 0, maxOpenBracket = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                minOpenBracket += 1;
                maxOpenBracket += 1;
            } else if (ch == ')') {
                minOpenBracket -= 1;
                maxOpenBracket -= 1;
            } else if (ch == '*') {
                minOpenBracket -= 1;
                maxOpenBracket += 1;
            }
            if (minOpenBracket < 0) {
                minOpenBracket = 0;
            }
            if (maxOpenBracket < 0) {
                return false;
            }
        }
        return minOpenBracket == 0;
    }
}