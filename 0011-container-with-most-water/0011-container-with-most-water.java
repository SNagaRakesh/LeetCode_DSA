class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n-1;

        int ans = 0;

        while(i < j) {
            int min = Math.min(height[i], height[j]);
            int distance = j - i;
            int area = min * distance;
            ans = Math.max(area, ans);
            if(height[i] <= height[j]) i++;
            else j--;
        }
        return ans;
    }
}