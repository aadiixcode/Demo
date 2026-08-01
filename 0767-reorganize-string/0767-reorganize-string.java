class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];

        int maxFreq = 0;
        char maxFreqChar = 'a';
        for (char c : s.toCharArray()) {
            freq[c-'a'] += 1;
            if(freq[c-'a'] > (n+1)/2){
                return "";
            }
            if(freq[c-'a'] > maxFreq){
                maxFreq = freq[c-'a'];
                maxFreqChar = c;
            }
        }

        char[] arr = new char[n];
        int index = 0;
        while(freq[maxFreqChar-'a'] > 0){
           arr[index] = maxFreqChar;
           index += 2;
           freq[maxFreqChar-'a'] -= 1;
        }

        for(int i=0;i<26;i++){
            while(freq[i]>0){
                if(index>=n){
                    index = 1;
                }
                arr[index] = (char) ('a'+i);
                index += 2;
                freq[i] -= 1;
            }
        }

        return new String(arr);
    }
}