class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();

        int n = word.length();
        int i=0;
        while(i<n){
            int count = 1;
            char curr = word.charAt(i);
            i += 1;
            while(i<n && count!=9 && word.charAt(i)==curr){
                i += 1;
                count += 1;
            }
            sb.append(count);
            sb.append(curr);
        }
        return sb.toString();
    }
}