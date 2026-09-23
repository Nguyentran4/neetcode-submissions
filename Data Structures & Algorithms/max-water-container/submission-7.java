class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){
            int curArea = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, curArea);

            if(heights[left] < heights[right]){
                left++;
            } else if (heights[left] > heights[right]){
                right--;
            } else {
                left++;
                right--;
            }
        }

        return maxArea;
    }
}
