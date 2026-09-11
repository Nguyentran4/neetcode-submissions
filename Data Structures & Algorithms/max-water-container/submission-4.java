class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int MaxArea = 0;
        while(left < right){
            int Area = Math.min(heights[left], heights[right]) * (right - left);
            MaxArea = Math.max(MaxArea, Area);

            if(heights[left] < heights[right]){
                left++;
            } else if(heights[left] > heights[right]){
                right--;
            } else {
                left++;
                right--;
            }
        }

        return MaxArea;
    }
}
