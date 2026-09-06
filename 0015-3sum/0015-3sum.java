class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        mergeSort(nums, 0, n-1);

        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i-1] == nums[i]) continue;
            int j = i + 1;
            int k = n - 1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0) {
                    j++;
                }
                else if(sum > 0) {
                    k--;
                }
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(nums[j] == nums[j-1] && j < k) j++;
                    while(nums[k] == nums[k+1] && j < k) k--;                    
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