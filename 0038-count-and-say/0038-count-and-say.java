class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int left = 0, right = 0;
            while (right < sb.length()) {
                if (sb.charAt(right) != sb.charAt(left)) {
                    temp.append(right - left);
                    temp.append(sb.charAt(left));
                    left = right;
                }
                right += 1;
            }
            temp.append(right-left);
            temp.append(sb.charAt(left));
            sb = temp;
        }
        return sb.toString();
    }
}