class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int n = s.length();

        int[] temp = new int[10];
        Arrays.fill(temp, -1);
        for (int i = 0; i < n; i++) {
            temp[s.charAt(i) - '0'] = i;
        }

        char[] charArr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int value = charArr[i] - '0';
            if (value == 9) {
                continue;
            }

            for (int j = 9; j >= 0; j--) {
                if (j > value && temp[j] > i) {
                    char tempChar = charArr[i];
                    charArr[i] = charArr[temp[j]];
                    charArr[temp[j]] = tempChar;
                    return Integer.valueOf(new String(charArr));
                }
            }
        }
        return num;
    }
}