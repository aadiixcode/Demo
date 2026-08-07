class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        long suffix = 0;
        for(int i=n-1;i>=0;i--){
            suffix += shifts[i];
            char ch = s.charAt(i);
            long newPosition = ((ch-'a') + suffix) % 26;
            char newChar = (char)('a'+newPosition);
            sb.append(newChar);
        }
        return sb.reverse().toString();
    }
}