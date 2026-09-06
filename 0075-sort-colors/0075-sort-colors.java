class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int mid = 0;
        int high = n-1;

        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, mid, left);
                left++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left]; 
        nums[left] = nums[right];
        nums[right] = temp;
    }
}