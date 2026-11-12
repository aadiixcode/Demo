class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int val : asteroids) {
            boolean flag = true;
            while (!st.isEmpty() && st.peek() > 0 && val < 0) {
                int a = st.peek();
                int b = Math.abs(val);
                if (a < b) {
                    st.pop();
                } else if (b < a) {
                    flag = false;
                    break;
                } else {
                    flag = false;
                    st.pop();
                    break;
                }
            }
            if (flag) {
                st.push(val);
            }
        }

        int[] ans = new int[st.size()];
        int i = st.size() - 1;
        while (st.size() > 0) {
            ans[i--] = st.pop();
        }
        return ans;
    }
}