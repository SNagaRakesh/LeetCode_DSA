class Solution {
    public String removeOuterParentheses(String s) {
        Deque<Character> st = new ArrayDeque<>();
        int n = s.length();

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(st.isEmpty()) {
                if(c == '(') st.push(c);
                else st.pop();
            }
            else {
                if(c == '(') st.push(c);
                else st.pop();

                if(!st.isEmpty()) ans.append(c);
            }
        }
        return ans.toString();
    }
}