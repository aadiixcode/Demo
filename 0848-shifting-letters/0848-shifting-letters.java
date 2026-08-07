class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        long[] prefix = new long[n];
        prefix[n-1] = shifts[n-1];
        for(int i=n-2;i>=0;i--){
            prefix[i] = shifts[i] + prefix[i+1];
        }
        System.out.println(Arrays.toString(prefix));

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            long newPosition = ((ch-'a') + prefix[i]) % 26;
            char newChar = (char)('a'+newPosition);
            sb.append(newChar);
        }
        return sb.toString();
    }
}