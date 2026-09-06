class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        mergeSort(nums, 0, n-1);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < n-2; j++) {
                if(j != (i+1) && nums[j] == nums[j-1]) continue;
                int k = j + 1;
                int l = n - 1;
                while(k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum > target) {
                        l--;
                    }
                    else if(sum < target) {
                        k++;
                    }
                    else {
                        ArrayList<Integer> temp = new ArrayList<>();

                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }
                }
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