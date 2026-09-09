class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();

        int i = 0;
        int j = n-1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                if(isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1)) {
                    return true;
                } 
                else {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }
    public static boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}