class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        String clean = s.trim().toLowerCase();
        if(clean.length() == 0) return true;

        StringBuilder sb = new StringBuilder(n);

        for(int i = 0; i < clean.length(); i++) {
            char ch = clean.charAt(i);
            if(Character.isLetter(ch) || Character.isDigit(ch)) {
                sb.append(ch);
            }
        }


        int i = 0, j = sb.length()-1;

        while(i <= j) {
            if(sb.charAt(i) == sb.charAt(j)) {
                i++;
                j--;
            }
            else return false;
        }
        return true;    
    }
}