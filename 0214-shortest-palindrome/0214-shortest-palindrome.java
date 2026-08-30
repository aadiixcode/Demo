class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - 1 - i] = temp;
        }

        String reverse = new String(arr);

        int i = 0;
        while (i < n) {
            String prefix = s.substring(0, n - i);
            String suffix = reverse.substring(i, n);
            if(prefix.equals(suffix)){
                return reverse.substring(0,i) + s;
            }
            i += 1;
        }
        return reverse+s;
    }
}