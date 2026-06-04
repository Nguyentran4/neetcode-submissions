class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];

        // Stores indices of nums in decreasing value order
        Deque<Integer> q = new LinkedList<>();

        int l = 0;

        for (int r = 0; r < n; r++) {
            // Remove smaller values from the back
            // because they cannot be max anymore
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }

            q.offerLast(r); // Add current index

            // Remove index if it is outside the window
            if (q.peekFirst() < l) {
                q.pollFirst();
            }

            // Start adding results once window size reaches k
            if (r + 1 >= k) {
                output[l] = nums[q.peekFirst()];

                // Move window forward
                l++;
            }
        }

        return output;
    }
}