class Solution {
    public int maximumLength(String s) {
        Map<Character, Map<Integer, Integer>> mp = new HashMap<>();

        int n = s.length();
        int maxLength = -1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }

                int length = j - i + 1;

                mp.putIfAbsent(ch, new HashMap<>());

                Map<Integer, Integer> lengths = mp.get(ch);

                lengths.put(length, lengths.getOrDefault(length, 0) + 1);

                if (lengths.get(length) >= 3) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
}