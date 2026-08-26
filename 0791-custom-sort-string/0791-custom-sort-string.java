class Solution {
    static class Pair {
        char ch;
        int position;

        Pair(char ch, int position) {
            this.ch = ch;
            this.position = position;
        }

    }

    public String customSortString(String order, String s) {

        int[] indices = new int[26];
        Arrays.fill(indices, Integer.MAX_VALUE);
        for (int i = 0; i < order.length(); i++) {
            indices[order.charAt(i) - 'a'] = i;
        }

        List<Pair> temp = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            Pair p = new Pair(ch, indices[ch - 'a']);
            temp.add(p);
        }
        Collections.sort(temp, (a, b) -> a.position - b.position);

        StringBuilder sb = new StringBuilder();
        for (Pair p : temp) {
            sb.append(p.ch);
        }
        return sb.toString();
    }
}