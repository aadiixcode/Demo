class Solution {
    void findSubstring(String s, List<String> temp) {
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                temp.add(sb.toString());
            }
        }
    }

    public String[] shortestSubstrings(String[] arr) {
        List<String> temp = new ArrayList<>();
        int n = arr.length;
        for (String s : arr) {
            findSubstring(s, temp);
        }

        // System.out.println(temp);

        String[] answer = new String[n];
        int index = 0;

        int left = 0, right = 0;
        for (String s : arr) {
            int stringSize = s.length();
            left = right;
            right += (stringSize * (stringSize + 1)) / 2;
            // System.out.println(left + ", " + right);
            Set<String> st = new HashSet<>();
            for (int i = 0; i < left; i++) {
                st.add(temp.get(i));
            }
            for (int i = right; i < temp.size(); i++) {
                st.add(temp.get(i));
            }

            // System.out.println(st);

            String smallestString = null;
            for (int i = left; i < right; i++) {
                String currentStr = temp.get(i);
                if (!st.contains(currentStr)) {
                    if (smallestString == null ||
                            currentStr.length() < smallestString.length() ||
                            (currentStr.length() == smallestString.length()
                                    && currentStr.compareTo(smallestString) < 0)) {
                        smallestString = currentStr;
                    }
                }
            }
            if (smallestString == null) {
                smallestString = "";
            }

            // System.out.println(smallestString);
            answer[index++] = smallestString;
        }
        return answer;
    }
}

/*
- Check all

*/