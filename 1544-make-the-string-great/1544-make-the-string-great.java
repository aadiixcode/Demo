class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(sb.isEmpty()){
                sb.append(c);
                continue;
            }
            char l = sb.charAt(sb.length()-1);
            char r1 = (char) (c-32);
            char r2 = (char) (c+32);
            if(l==r1 || l==r2){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                sb.append(c);
            }
           
        }
        return sb.toString();
    }
}