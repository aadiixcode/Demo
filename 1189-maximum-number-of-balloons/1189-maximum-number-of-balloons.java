class Solution {
    public int maxNumberOfBalloons(String s) {
        int[] freq = new int[26];
        int count=0;
        for(char c: s.toCharArray()){
            freq[c-'a']+=1;
            if(freq[0]>=1 && freq[1]>=1 && freq[11]>=2 && freq[14]>=2 && freq[13]>=1){
                count+=1;
                freq[0] -= 1;
                freq[1] -= 1;
                freq[11] -= 2;
                freq[14] -= 2;
                freq[13] -= 1;
            }
        }
        return count;
    }
}