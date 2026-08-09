class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
                continue;
            }
            char l = st.peek();
            char r1 = (char) (c-32);
            char r2 = (char) (c+32);
            if(l==r1 || l==r2){
                st.pop();
            }
            else{
                st.push(c);
            }
           
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}