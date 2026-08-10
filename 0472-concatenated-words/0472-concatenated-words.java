class Solution {

    boolean isExist(String word, Set<String> st, Map<String, Boolean> mp) {
        if (mp.containsKey(word)) {
            return mp.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i, word.length());
            if (st.contains(prefix) && st.contains(suffix)) {
                mp.put(word, true);
                return true;
            } else if (st.contains(prefix) && isExist(suffix, st, mp)) {
                mp.put(word, true);
                return true;
            }
        }
        mp.put(word, false);
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> st = new HashSet<>();
        for (String word : words) {
            st.add(word);
        }
        List<String> ans = new ArrayList<>();
        Map<String, Boolean> mp = new HashMap<>();
        for (String word : words) {
            if (isExist(word, st, mp)) {
                ans.add(word);
            }
        }
        return ans;
    }
}