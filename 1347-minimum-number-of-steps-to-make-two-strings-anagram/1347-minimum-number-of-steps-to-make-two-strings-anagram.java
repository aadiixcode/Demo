class Solution {
    public int minSteps(String s, String t) {
        int[] f1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            f1[s.charAt(i)-'a'] += 1;
        }

        int steps = 0;
        for (int i = 0; i < s.length(); i++) {
            if(f1[t.charAt(i) - 'a'] > 0){
                f1[t.charAt(i) - 'a'] -= 1;
            }
            else{
                steps += 1;
            }
        }
        return steps;
    }
}

// 1 2
// 2 1