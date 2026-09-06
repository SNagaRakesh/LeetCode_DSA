class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = -1;
        int minDistance = Integer.MAX_VALUE;

        mergeSort(nums, 0, n-1);
        
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == target) return sum;
                int diff = Math.abs(sum - target);
                if(diff < minDistance) {
                    minDistance = diff;
                    ans = sum;
                }    
                else if(sum < target) j++;
                else k--;
            }
        }
        return ans;
    }
    public static void mergeSort(int[] nums, int low, int high) {
        if(low < high) {
            int mid = (low + (high - low) / 2);
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }
    public static void merge(int[] nums, int low, int mid, int high) {
        int n = nums.length;

        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while(i <= mid && j <= high) {
            if(nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            }
            else {
                temp[k++] = nums[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = nums[i++];
        }
        while(j <= high) {
            temp[k++] = nums[j++];
        }

        for(int a = 0, b = low; a < temp.length; a++, b++) {
            nums[b] = temp[a];
        }
    }
}