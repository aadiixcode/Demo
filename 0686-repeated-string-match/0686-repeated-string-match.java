class Solution {
    public int repeatedStringMatch(String a, String b) {
        int len_a = a.length();
        int len_b = b.length();
        int steps = len_b / len_a;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= steps; i++) {
            sb.append(a);
        }
        if (sb.toString().indexOf(b) != -1) {
            return steps;
        }
        sb.append(a);
        if (sb.toString().indexOf(b) != -1) {
            return steps + 1;
        }
        sb.append(a);
        if (sb.toString().indexOf(b) != -1) {
            return steps + 2;
        }
        return -1;
    }
}