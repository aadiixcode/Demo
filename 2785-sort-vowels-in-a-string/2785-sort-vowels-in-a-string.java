class Solution {
    public String sortVowels(String s) {
        List<Character> temp = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                temp.add(ch);
            }
        }
        Collections.sort(temp);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                sb.append(temp.get(i));
                i += 1;
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}