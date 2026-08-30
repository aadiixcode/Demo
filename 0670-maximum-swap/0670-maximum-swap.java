class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int n = s.length();

        int[] temp = new int[n];
        temp[n - 1] = n - 1;
        int max = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(max) > s.charAt(i)) {
                temp[i] = max;
            } else {
                temp[i] = i;
                if (s.charAt(i) > s.charAt(max)) {
                    max = i;
                }
            }
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if(temp[i] > i){
               char ch = arr[i];
               arr[i] = arr[temp[i]];
               arr[temp[i]] = ch;
               break;
            }
        }
        return Integer.valueOf(new String(arr));
    }
}