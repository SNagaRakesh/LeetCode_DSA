class Solution {
    public String frequencySort(String s) {
        int n = s.length();

        List<Character>[] bucket = new List[n+1];

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(Map.Entry<Character, Integer> el : map.entrySet()) {
            char character = el.getKey();
            int frequency = el.getValue();

            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(character);
        }

        StringBuilder result = new StringBuilder();

        for(int i = bucket.length-1; i > 0; i--) {
            if(bucket[i] != null) {
                for(char ch : bucket[i]) {
                    for(int j = 0; j < i; j++) {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }
}