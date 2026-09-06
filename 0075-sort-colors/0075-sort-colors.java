class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, mid = 0, high = n-1;

        while(mid <= high) {
            if(nums[mid] == 0) {
                if(left != mid)
                    swap(nums, mid, left);
                left++;
                mid++;
            }
            else if(nums[mid] == 1) {
                mid++;
            }
            else if(nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}