class Solution {
    public int numberOfSubstrings(String s) {
        int i = 0, j=0;
        int[] freq = new int[3];
        int ans = 0;
        int  n = s.length();
        while(j<n){
            char c = s.charAt(j++);
            freq[c-'a'] += 1;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                ans += (n-j+1);
                freq[s.charAt(i)-'a']-=1;
                i+=1;          
            }
        }
        return ans;
    }
}