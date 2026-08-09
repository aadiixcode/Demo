class Solution {
    public boolean detectCapitalUse(String s) {
        if(s.length()==1){
            return true;
        }
        
        
        boolean firstCharCapital = Character.isUpperCase(s.charAt(0)) ? true : false;
        boolean secondCharCapital = Character.isUpperCase(s.charAt(1)) ? true : false;
        for (int i = 2; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!firstCharCapital && Character.isUpperCase(ch)) {
                return false;
            }

            if (firstCharCapital && secondCharCapital && Character.isLowerCase(ch)) {
                return false;
            }

            if (firstCharCapital && !secondCharCapital && Character.isUpperCase(ch)) {
                return false;
            }
        }
        if (!firstCharCapital && secondCharCapital) {
            return false;
        }
        return true;
    }
}