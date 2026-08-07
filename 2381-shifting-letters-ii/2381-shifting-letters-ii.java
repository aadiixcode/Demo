class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n];

        for (int[] shift : shifts) {
            int l = shift[0];
            int r = shift[1];
            int direction = shift[2];
            int x=0;
            if (direction == 0) {
                x = -1;
            } else if (direction == 1) {
                x = 1;
            }

            diff[l] += x;
            if(r+1<n){
                diff[r+1] -= x;
            }
        }

        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int shift = diff[i] % 26;
            if (shift < 0) {
                shift += 26;
            }

            int newPosition = ((ch - 'a') + shift) % 26;
            char newChar = (char) ('a' + newPosition);
            sb.append(newChar);
        }
        return sb.toString();
    }
}