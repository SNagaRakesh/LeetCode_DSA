class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        List<char[]> strsArray = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            strsArray.add(strs[i].toCharArray());
        }

        String[] anagrams = new String[n];

        int idx = 0;
        for(char[] c : strsArray) {
            Arrays.sort(c);
            anagrams[idx] = new String(c);
            idx++;
        }

        

        HashSet<String> uniqueAnagrams = new HashSet<>();

        for(String str : anagrams) {
            uniqueAnagrams.add(str);
        }

        List<List<String>> ans = new ArrayList<>();

        for(String s : uniqueAnagrams) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(anagrams[i].equals(s)) {
                    temp.add(strs[i]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
