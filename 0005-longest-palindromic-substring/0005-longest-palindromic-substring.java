class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int maxLength = 0;
        int start = -1;
        int end = -1;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isPalindrome(s.substring(i, j+1))) {
                    if(j - i + 1 > maxLength) {
                        maxLength = Math.max(j-i+1, maxLength);
                        start = i;
                        end = j;
                    }                    
                }
            }
        }
        return s.substring(start, end+1);
    }
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}