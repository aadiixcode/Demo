class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n != m){
            return false;
        }
        
        int[] contains1 = new int[26];
        int[] contains2 = new int[26];
        for (int i=0;i<n;i++) {
            contains1[word1.charAt(i) - 'a'] += 1;
            contains2[word2.charAt(i) - 'a'] += 1;
        }

        int[] fCount1 = new int[n+1];
        int[] fCount2 = new int[n+1];
        for(int i=0;i<26;i++){
            if(contains1[i] >0 && contains2[i]==0){
                return false;
            }

            if(contains1[i]>0){
                fCount1[contains1[i]] += 1;
            }
            if(contains2[i]>0){
                fCount2[contains2[i]] += 1;
            }
        }

        for(int i=0;i<n+1;i++){
            if(fCount1[i] != fCount2[i]){
                return false;
            }
        }
        return true;
       
    }
}

/* 

a 1
b 2
c 1
z 3


a 2
b 2
c 1
z 2

*/