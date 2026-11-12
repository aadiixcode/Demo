class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxWidth = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int currInd = st.pop();
                int prevSmaller = st.isEmpty() ? -1 : st.peek();
                int nextSmaller = i;
                int width = heights[currInd] * (nextSmaller - prevSmaller - 1);
                maxWidth = Math.max(width, maxWidth);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int currInd = st.pop();
            int prevSmaller = st.isEmpty() ? -1 : st.peek();
            int nextSmaller = n;
            int width = heights[currInd] * (nextSmaller - prevSmaller - 1);
            maxWidth = Math.max(width, maxWidth);
        }
        return maxWidth;
    }
}