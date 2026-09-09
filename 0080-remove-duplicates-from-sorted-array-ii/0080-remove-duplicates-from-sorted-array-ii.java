class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if(n <= 2) {
            return 2;
        }

        int i = 0;
        int j = 2;

        while(j < n) {
            if(nums[i] != nums[j]) {
                if(i+2 != j) 
                    swap(nums, i+2, j);
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return i+2;
    }
    public static void swap(int[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}