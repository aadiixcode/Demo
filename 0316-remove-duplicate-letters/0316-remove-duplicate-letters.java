class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastAppearance = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastAppearance[ch - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(visited[ch-'a']){
                continue;
            }
            while (sb.length() > 0) {
                char lastChar = sb.charAt(sb.length() - 1);
                if (lastChar > ch && lastAppearance[lastChar - 'a'] > i) {
                    sb.deleteCharAt(sb.length() - 1);
                    visited[lastChar-'a'] = false;
                } else {
                    break;
                }
            }
            sb.append(ch);
            visited[ch-'a'] = true;
        }

        return sb.toString();
    }
}