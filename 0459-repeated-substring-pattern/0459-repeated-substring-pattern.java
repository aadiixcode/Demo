class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String temp = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
                int times = n / i;
                while (times > 0) {
                    sb.append(temp);
                    times -= 1;
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}