class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        String[] anagrams = new String[n];

        for(int i = 0; i < n; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            anagrams[i] = new String(charArray);
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
