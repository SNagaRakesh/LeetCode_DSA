class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        HashSet<Character> set = new HashSet<>();

        if(n == 0) return 0;

        int ans = 1;
        int left = 0;

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(!set.contains(ch)) {
                set.add(ch);
            }
            else {
                while(set.contains(ch)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(ch);
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}