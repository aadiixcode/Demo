class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        long steps = 0;
        int black = 0;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                black += 1;
            }
            else{
                steps += black;
            }
        }
        return steps;
    }
}

// 1 ->  black
// 0 ->  white

// 00 101010 11
// 00 0101

// 100