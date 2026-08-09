class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n/2;

        int leftVowels=0,rightVowels=0;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            int index = "aeiouAEIOU".indexOf(c);
            if(index != -1){
                if(i>=mid){
                    rightVowels += 1;
                }
                else{
                    leftVowels += 1;
                }
            } 
        }
        return leftVowels==rightVowels;
    }
}