class Solution {
    class Pair{
        String s;
        int level;
        Pair(String str, int l){
            s=str;
            level = l;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;

        Set<String> set = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);

        int count = 0;
        while (!q.isEmpty()){
            Pair p = q.poll();
            String word = p.s;
            int dist = p.level;
            if(word.equals(endWord)){
                count=dist;
                break;
            }
            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String next = new String(arr);
                    if (set.contains(next)) {
                        q.add(new Pair(next, dist + 1));
                        set.remove(next);
                    }
                }
            }
        }
        return count;
    }
}