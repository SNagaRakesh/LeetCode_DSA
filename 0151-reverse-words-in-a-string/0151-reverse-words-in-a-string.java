class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();

        Deque<String> st = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == ' ' && word.length() != 0) {
                st.push(word.toString());
                word.delete(0, word.length());
            }
            else {
                if(c == ' ') continue;
                word.append(c);
            }
        }
        if(word.length() != 0) {
            st.push(word.toString().trim());
        }
        while(!st.isEmpty()) {
            ans.append(st.pop());
            if(!st.isEmpty()) {
                ans.append(" ");
            } 
        }
        return ans.toString();
    }
}