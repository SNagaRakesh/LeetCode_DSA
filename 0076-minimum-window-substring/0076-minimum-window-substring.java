class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        int[] minIdx = {0, 0};

        int i = 0, j = 0, satisfied = 0;

        HashMap<Character, Integer> wFMap = new HashMap<>();

        if(s.length() != 0) {
            wFMap.put(s.charAt(j), wFMap.getOrDefault(s.charAt(j), 0) + 1);
            if((int)wFMap.get(s.charAt(j)) == (int)freqMap.getOrDefault(s.charAt(j), Integer.MAX_VALUE)) {
                satisfied++;
            }
        }

        while(j < s.length()) {
            if(freqMap.size() == satisfied) {
                if(min > j - i + 1 && freqMap.size() == satisfied) {
                    min = j - i + 1;
                    minIdx[0] = i;
                    minIdx[1] = j;
                }
                wFMap.put(s.charAt(i), wFMap.get(s.charAt(i)) - 1);
                if(wFMap.get(s.charAt(i)) == freqMap.getOrDefault(s.charAt(i), 0) - 1) {
                    satisfied--;
                }
                i++;
            }
            else {
                j++;
                if(j < s.length()) {
                    wFMap.put(s.charAt(j), wFMap.getOrDefault(s.charAt(j), 0) + 1);
                    if((int)wFMap.get(s.charAt(j)) == (int)freqMap.getOrDefault(s.charAt(j), Integer.MAX_VALUE)) {
                        satisfied++;
                    }
                    if(min > j - i + 1 && freqMap.size() == satisfied) {
                        min = j - i + 1;
                        minIdx[0] = i;
                        minIdx[1] = j;
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(minIdx[0], minIdx[1]+1);
    }
}