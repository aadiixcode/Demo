class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k == n) {
            return "0";
        }

        Stack<Character> st = new Stack<>();
        for (char ch : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k -= 1;
            }
            st.push(ch);
        }
        while (k > 0) {
            st.pop();
            k -= 1;
        }

        char[] arr = new char[st.size()];
        int i = st.size() - 1;
        while (st.size() > 0) {
            arr[i--] = st.pop();
        }

        String ans = new String(arr);
        i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i += 1;
        }
        if (i == ans.length()) {
            return "0";
        }
        return ans.substring(i, ans.length());
    }
}

// 11229