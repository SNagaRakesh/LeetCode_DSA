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

        HashMap<String, List<String>> map = new HashMap<>();

        int index = 0;

        for(String anagram : anagrams) {
            if(map.containsKey(anagram)) {
                map.get(anagram).add(strs[index]);
            }
            else{
                map.put(anagram, new ArrayList<>());
                map.get(anagram).add(strs[index]);
            }
            index++;
        }

        List<List<String>> ans = new ArrayList<>();

        for(List<String> v : map.values()){
            ans.add(v);
        }
        return ans;
    }
}
