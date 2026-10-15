class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<Integer>[] bucket = new ArrayList[n+1];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(bucket[entry.getValue()] == null)
                bucket[entry.getValue()] = new ArrayList<>();
            bucket[entry.getValue()].add(entry.getKey());
        }

        int j = 0;

        for(int i = n; i > 0; i--) {
            if(bucket[i] == null) continue;
            for(int a : bucket[i]) {
                if(j == k) return ans;
                ans[j++] = a;
            }
        }
        return ans;
    }
}