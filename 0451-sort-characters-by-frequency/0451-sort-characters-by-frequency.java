class Solution {
    public String frequencySort(String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n ; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

        pq.addAll(map.entrySet());

        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> ele = pq.poll();
            for(int i = 0; i < ele.getValue(); i++) {
                result.append(ele.getKey());
            }
        }

        return result.toString();
    }
}