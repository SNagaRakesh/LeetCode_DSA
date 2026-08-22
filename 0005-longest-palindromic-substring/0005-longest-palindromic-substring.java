class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = -1;
        int end = -1;

        int maxLength = 0;

        for(int i = 0; i < n-1; i++) {
            // odd palindrome
            int left = i;
            int right = i;
            
            int[] odd = isPalindrome(s, left, right);
            
            if (odd[1] - odd[0] + 1 > maxLength) {
                maxLength = odd[1] - odd[0] + 1;
                start = odd[0];
                end = odd[1];
            }
            
            // even palindrome 
            left = i;
            right = i+1;

            int[] even = isPalindrome(s, left, right);

            if (even[1] - even[0] + 1 > maxLength) {
                maxLength = even[1] - even[0] + 1;
                start = even[0];
                end = even[1];
            }          
        }
        return (start == -1 || end == -1) ? s.substring(0, 1) : s.substring(start, end + 1);
    }
    public static int[] isPalindrome(String s, int left, int right) {

        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)){
                return new int[] {left + 1, right - 1};
            }
            left--;
            right++;
        }
        return new int[] {left + 1, right - 1};
    }
}