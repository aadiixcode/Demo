class Solution {
    void findSubstring(String s, Map<String, Integer> mp, List<String> temp) {
        Set<String> st = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                String subString = sb.toString();
                st.add(subString);
                temp.add(subString);
            }
        }
        for (String subString : st) {
            mp.put(subString, mp.getOrDefault(subString, 0) + 1);
        }
    }

    public String[] shortestSubstrings(String[] arr) {
        Map<String, Integer> mp = new HashMap<>();
        List<String> temp = new ArrayList<>();
        for (String s : arr) {
            findSubstring(s, mp, temp);
        }

        String[] ans = new String[arr.length];
        int ansIndex = 0;
        int left = 0, right = 0;
        for (String s : arr) {
            int stringSize = s.length();
            left = right;
            right += (stringSize * (stringSize + 1)) / 2;
            String smallerString = "";
            for (int i = left; i < right; i++) {
                String subString = temp.get(i);
                if (mp.get(subString) == 1) {
                    if (smallerString.equals("")
                            || subString.length() < smallerString.length()
                            || (subString.length() == smallerString.length()
                                    && subString.compareTo(smallerString) < 0)) {
                        smallerString = subString;
                    }
                }
            }
            ans[ansIndex++] = smallerString;
        }
        return ans;
    }
}

/*
- Check all

*/