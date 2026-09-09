class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if(n == 0) return true;

        StringBuilder sb = new StringBuilder(n);

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(Character.isLetter(ch) || Character.isDigit(ch)) {
                sb.append(ch);
            }
        }

        String cleanS = sb.toString().toLowerCase();

        int i = 0, j = cleanS.length()-1;

        while(i <= j) {
            if(cleanS.charAt(i) == cleanS.charAt(j)) {
                i++;
                j--;
            }
            else return false;
        }
        return true;    
    }
}