class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int startInd = -1, count = 0, minLen = Integer.MAX_VALUE;
        Map<Character, Integer> mp = new HashMap<>();
        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;
        while (j < n) {
            char ch = s.charAt(j);
            if (!mp.containsKey(ch)) {
                j += 1;
                continue;
            }

            if (mp.get(ch) > 0) {
                count += 1;
            }
            mp.put(ch, mp.get(ch) - 1);

            while (count == m) {
                if ((j - i + 1) < minLen) {
                    startInd = i;
                    minLen = j - i + 1;
                }
                char c = s.charAt(i);
                if (mp.containsKey(c)) {
                    if (mp.get(c) >= 0) {
                        count -= 1;
                    }
                    mp.put(c, mp.get(c) + 1);
                }
                i += 1;
            }
            j += 1;
        }

        if (startInd != -1) {
            return s.substring(startInd, startInd + minLen);
        }
        return "";
    }
}