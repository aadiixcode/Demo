class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int l=s.length()-1,r=s.length()-1;
        while(l>=0){
            r=l;
            while(l>=0 && s.charAt(l)!=' '){
                l-=1;
            }
            sb.append(s.substring(l+1,r+1));
            sb.append(" ");
            while(l>=0 && s.charAt(l)==' '){
                l-=1;
            }
        }
        return sb.toString().trim();
    }
}