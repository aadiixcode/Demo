class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> mp = new HashMap<>();
        int n = s.length();
        int maxLength = -1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int length = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }

                length += 1;
                String key = ch + ":" + length;
                mp.put(key, mp.getOrDefault(key, 0) + 1);
                if (mp.get(key) >= 3) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        System.out.println(mp);
        return maxLength;
    }
}