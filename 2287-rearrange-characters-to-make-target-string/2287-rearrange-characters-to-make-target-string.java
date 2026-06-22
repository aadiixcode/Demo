class Solution {
    public int rearrangeCharacters(String s, String t) {
        int[] f1 = new int[26];
        for(char c:t.toCharArray()){
            f1[c-'a']+=1;
        }

        int[] f2 = new int[26];
        for(char c:s.toCharArray()){
            f2[c-'a']+=1;
        }

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(f1[i]>0){
                ans = Math.min(ans,f2[i]/f1[i]);
            }
        }
        return ans;
    }
}