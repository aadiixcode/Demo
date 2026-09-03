class Solution {

    public boolean checkValidString(String s) {
        Stack<Integer> bracket = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                bracket.push(i);
            } else if (ch == ')') {
                if (!bracket.isEmpty() && s.charAt(bracket.peek()) == '(') {
                    bracket.pop();
                } else {
                    if (!star.isEmpty() && star.peek() < i) {
                        star.pop();
                    }
                    else {
                        return false;
                    }
                }
            } else {
                star.push(i);
            }
        }

        while(!bracket.isEmpty()){
            int bracketIndex = bracket.peek();
            if(s.charAt(bracketIndex) == '('){
                if (!star.isEmpty() && star.peek() > bracketIndex) {
                    bracket.pop();
                    star.pop();
                }
                else {
                    return false;
                }
            }
            else if(s.charAt(bracketIndex) == ')'){
                if (!star.isEmpty() && star.peek() < bracketIndex) {
                    bracket.pop();
                    star.pop();
                }
                else {
                    return false;
                }
            }
        }

        return bracket.isEmpty();
    }
}