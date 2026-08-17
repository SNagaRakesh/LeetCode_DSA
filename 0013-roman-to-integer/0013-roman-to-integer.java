import java.util.Map;
class Solution {
    public int romanToInt(String s) {
        int n = s.length();

        // Map<Character, Integer> roman = new Map.of(
        //     'I', 1,
        //     'V', 5, 
        //     'X', 10,
        //     'L', 50, 
        //     'C', 100, 
        //     'D', 500, 
        //     'M', 1000
        // );

        int count = 0;

        for(int i = s.length()-1; i >= 0; i--) {
            int current = getValue(s.charAt(i));
            int next = (i < n-1) ? getValue(s.charAt(i+1)) : 0;
            if(i < n-1 && current < next) {
                count -= current;
            }
            else {
                count += current;
            }
        }
        return count;
    }
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}