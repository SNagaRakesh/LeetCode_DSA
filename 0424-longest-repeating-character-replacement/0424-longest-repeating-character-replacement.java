class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int left = 0;
        int right = 0;

        int[] freq = new int[26];

        int max = 0;
        int maxFreq = 0;

        while(left < n && right < n) {
            char ch = s.charAt(right);
            freq[ch-'A']++;
            maxFreq = Math.max(maxFreq, freq[ch-'A']);

            int rNeeded = (right - left + 1) - maxFreq;

            if(rNeeded <= k) {
                max = Math.max(max, (right - left + 1));
                right++;
            }
            else{
                freq[s.charAt(left)-'A']--;
                left++;
                right++;
            }
        }
        return max;
    }
}