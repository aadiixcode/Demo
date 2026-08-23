class Solution {
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        String vowels = "aeiou";
        int count = 0;
        for (int i = 0; i < n; i++) {
            int vowelCount = 0, consCount = 0;
            for (int j = i; j < n; j++) {
                if (vowels.indexOf(s.charAt(j)) != -1) {
                    vowelCount += 1;
                } else {
                    consCount += 1;
                }

                if (vowelCount == consCount && (vowelCount * consCount) % k == 0) {
                    count += 1;
                }
            }
        }
        return count;
    }
}