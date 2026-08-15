class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char chars = s.charAt(i);
            char chart = t.charAt(i);

            if(map1.containsKey(chars)) {
                if(map1.get(chars) == chart) {
                    continue;
                }
                else{
                    return false;
                }
            }
            else if (map2.containsKey(chart)) {
                if(map2.get(chart) == chars) {
                    continue;
                }
                else{
                    return false;
                }
            }
            else {
                map1.put(chars, chart);
                map2.put(chart, chars);
            }
        }
        return true;
    }
}