class Solution {
    public String orderlyQueue(String s, int k) {
        char[] arr = s.toCharArray();
        if (k > 1) {
            Arrays.sort(arr);
            return new String(arr);
        }

        String ans = new String(arr);
        String concatenation = s + s;
        int n = s.length();
        for(int i=1;i<=n-1;i++){
            String rotatedString = concatenation.substring(i,n+i);
            if(rotatedString.compareTo(ans) < 0){
                ans = rotatedString;
            }
        }
        return ans;
    }
}