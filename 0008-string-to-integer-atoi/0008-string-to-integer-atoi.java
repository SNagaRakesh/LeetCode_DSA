class Solution {
    public int myAtoi(String s) {
        int n = s.length();

        int num = 0;
        int sign = 1;
        int i = 0;

        // 1. White space
        while(i < s.length() && s.charAt(i) == ' ') {
            i = i + 1;
        }

        // 2. Signedness
        if(i < s.length()) {
            if(s.charAt(i) == '-') {
                sign = -1;
                i = i + 1;
            }
            else if(s.charAt(i) == '+') {
                i = i + 1;
            }
        }

        // 3. Conversion
        while(i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // MAX = +1,147,483,647
            // MIN = -1,147,483,648

            if(num == Integer.MAX_VALUE / 10) {
                if(sign == 1) {
                    if(digit >= 7) {
                        return Integer.MAX_VALUE;
                    }
                }
                else if(sign == -1) {
                    if(digit >= 8) {
                        return Integer.MIN_VALUE;
                    }
                }
            }

            if(num > Integer.MAX_VALUE / 10) {
                if(sign == 1) {
                    return Integer.MAX_VALUE;
                }
                else{
                    return Integer.MIN_VALUE;
                }
            }

            num = num * 10 + digit;
            i = i + 1;
        }

        return num * sign;
    }
}