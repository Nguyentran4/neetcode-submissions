class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> res = new PriorityQueue<>();

        for(int n : nums){
            res.offer(n);
            if(res.size() > k){
                res.poll();
            }
        }

        return res.peek();
    }
}
