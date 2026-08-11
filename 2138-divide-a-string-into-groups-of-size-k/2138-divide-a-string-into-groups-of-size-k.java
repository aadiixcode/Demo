class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int numberOfWords = (int) Math.ceil((double) n/k);
        String[] ans = new String[numberOfWords];
        int ansInd = 0;

        int i = 0;
        while (i < n) {
            int j = i;
            StringBuilder sb = new StringBuilder();
            while (j < i + k) {
                if(j<n){
                    sb.append(s.charAt(j));
                }
                else{
                    sb.append(fill);
                }
                j += 1;
            }
            ans[ansInd++] = sb.toString();
            i = j;
        }
        return ans;
    }
}