class Solution {
    public int numberOfSubstrings(String s) {
        int[] arr = new int[3];
        int i = 0, j = 0, count = 0;

        int n = s.length();
        while (j < n) {
            arr[s.charAt(j) - 'a'] += 1;
            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                count += (n - j);
                arr[s.charAt(i) - 'a'] -= 1;
                i += 1;
            }
            j += 1;
        }
        return count;
    }
}