class Solution {
    public int largestRectangleArea(int[] heights) {
        int Maxarea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= heights.length; i++){
            while(!stack.isEmpty() &&
                ((i == heights.length) || heights[i] <= heights[stack.peek()])){
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;    //width = i - leftBoundary - 1.
                    Maxarea = Math.max(Maxarea, h * w);

            }
            stack.push(i);
        }


        return Maxarea;
    }
}
