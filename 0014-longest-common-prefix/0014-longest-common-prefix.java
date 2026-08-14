class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int j = 0; j < strs[0].length(); j++) {
            char ch = strs[0].charAt(j);
            for(int i = 1; i < strs.length; i++) {
                if(j < strs[i].length() && ch == strs[i].charAt(j)) {
                }
                else {
                    return strs[0].substring(0,j);
                }
            }
            
        }
        return strs[0];
    }
}