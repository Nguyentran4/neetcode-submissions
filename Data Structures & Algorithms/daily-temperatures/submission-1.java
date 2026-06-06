class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        // non-increasing stack
        Deque<Integer> stack = new ArrayDeque<>(); //stores indices
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                res[prevDay] = i - prevDay;
            }
            stack.push(i);
        }

        return res;
    }
}
