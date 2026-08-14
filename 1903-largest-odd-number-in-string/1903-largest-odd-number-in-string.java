class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();

        int left = 0;

        for(int i = n-1; i >= 0; i--) {
            int d = num.charAt(i) - '0';

            if(d % 2 != 0) {
                return num.substring(left, i+1);
            }
            else{
                continue;
            }
        }
        return "";
    }
}