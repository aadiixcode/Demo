class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m) {
            return false;
        }

        char[] arr = s.toCharArray();
        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (char ch : arr) {
                freq[ch - 'a'] += 1;
                if (freq[ch - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }

        List<Integer> mismatchIndex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                mismatchIndex.add(i);
            }
        }
        if (mismatchIndex.size() == 2) {
            int left = mismatchIndex.get(0);
            int right = mismatchIndex.get(1);
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            if(new String(arr).equals(goal)){
                return true;
            }
        }
        return false;
    }
}