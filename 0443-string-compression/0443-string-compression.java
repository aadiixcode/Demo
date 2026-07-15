class Solution {
    public int compress(char[] s) {
        int count = 0;
        int i = 0, j = 1;
        for (j = 1; j < s.length; j++) {
            if (s[j] != s[i]) {
                int size = j - i;
                s[count++] = s[i];
                if (size > 1) {
                    String temp = String.valueOf(size);
                    // System.out.println(temp);
                    for (char c : temp.toCharArray()) {
                        s[count++] = c;
                    }
                }
                i = j;
            }
        }
        int size = j - i;
        s[count++] = s[i];
        if (size > 1) {
            String temp = String.valueOf(size);
            // System.out.println(temp);
            for (char c : temp.toCharArray()) {
                s[count++] = c;
            }
        }
        i = j;

        return count;
    }
}

// 12 120 1200