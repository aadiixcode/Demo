class Solution {
    public int largestVariance(String s) {
        int n = s.length();
        Set<Character> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st.add(s.charAt(i));
        }

        int ans = 0;
        for (char first = 'a'; first <= 'z'; first++) {
            for (char second = 'a'; second <= 'z'; second++) {
                if (!st.contains(first) || !st.contains(second)) {
                    continue;
                }

                int firstCount = 0, secondCount = 0;
                boolean isSecondAlreadyAppeared = false;
                for (char c : s.toCharArray()) {
                    if (c == first) {
                        firstCount += 1;
                    } else if (c == second) {
                        secondCount += 1;
                    }

                    if (secondCount > firstCount) {
                        firstCount = 0;
                        secondCount = 0;
                        isSecondAlreadyAppeared = true;
                    } else if (firstCount >= secondCount) {
                        if(secondCount > 0){
                            ans = Math.max(ans,firstCount-secondCount);
                        }
                        else if(secondCount==0 && isSecondAlreadyAppeared){
                             ans = Math.max(ans,firstCount-1);
                        }
                    }
                }
            }
        }
        return ans;
    }
}