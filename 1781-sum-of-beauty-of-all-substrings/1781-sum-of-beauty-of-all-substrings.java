class Solution {
    public int beautySum(String s) {
        int n = s.length();

        int beautySum = 0;

        for(int i = 0; i < n; i++) {
            int[] freq = new int[27];

            for(int j = i; j < n; j++) {

                char ch = s.charAt(j);
                freq[ch - 'a']++;

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for(int k = 0; k < freq.length; k++) {
                    if(freq[k] != 0) {
                        if(freq[k] < min) min = freq[k];
                        if(freq[k] > max) max = freq[k];
                    }
                }

                beautySum += max - min;
            }
        }
        return beautySum;
    }
}