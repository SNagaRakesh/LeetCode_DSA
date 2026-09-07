class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(nums[0]);
        
        for(int i = 1; i < n; i++) {
            if(nums[i] != nums[i-1]) {
                list.add(nums[i]);
            }
        }

        for(int i = 0; i < list.size(); i++){
            nums[i] = list.get(i);
        }
        return list.size();
    }
}