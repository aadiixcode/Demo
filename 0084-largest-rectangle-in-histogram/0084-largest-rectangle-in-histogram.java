class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] ps = new int[n];
        int[] ns = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            ps[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            ns[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int maxWidth = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int length = (i - ps[i]) + (ns[i] - i - 1);
            maxWidth = Math.max(maxWidth, length * heights[i]);
        }
        return maxWidth;
    }
}