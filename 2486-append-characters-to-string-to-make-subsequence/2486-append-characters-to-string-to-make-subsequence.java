class Solution {
    public int appendCharacters(String s, String t) {
        int i=0,j=0;
        while(j<s.length() && i<t.length()){
            if(s.charAt(j)==t.charAt(i)){
                i+=1;
                j+=1;
            }
            else{
                j+=1;
            }
        }
        return t.length()-i;
    }
}