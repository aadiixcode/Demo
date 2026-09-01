class Solution {
    public int maximumLength(String s) {
        Map<Map<Character,Integer>, Integer> mp = new HashMap<>();
        int n = s.length();
        int maxLength = -1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            for (int j = i; j < n; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }
                Map<Character,Integer> inner = new HashMap<>();
                inner.put(ch,j-i+1);
                mp.put(inner, mp.getOrDefault(inner, 0) + 1);
                if (mp.get(inner) >= 3) {
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }

        System.out.println(mp);
        return maxLength;
    }
}