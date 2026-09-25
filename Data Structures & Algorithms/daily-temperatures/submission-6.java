class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>(); //stores indices
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int in = stack.pop();
                res[in] = i - in;
            }

            stack.push(i);
        }

        return res;
    }
}
