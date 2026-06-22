class Solution {
    public int maxNumberOfBalloons(String s) {
        int a=0,b=0,l=0,n=0,o=0;
        for(char c: s.toCharArray()){
            if(c=='a') a+=1;
            else if(c=='b') b+=1;
            else if(c=='l') l+=1;
            else if(c=='n') n+=1;
            else if(c=='o') o+=1;
        }
        o/=2;
        l/=2;
        return Math.min(a,Math.min(b,Math.min(l,Math.min(o,n))));
    }
}