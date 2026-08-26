class Solution {
    public String customSortString(String order, String s) {

        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for(char ch: order.toCharArray()){
            while(freq[ch-'a'] > 0){
                sb.append(ch);
                freq[ch-'a']-=1;
            }
        }

        for(int i=0;i<26;i++){
            while(freq[i]>0){
                sb.append((char)('a'+i));
                freq[i]-=1;
            }
        }
        return sb.toString();
    }
}