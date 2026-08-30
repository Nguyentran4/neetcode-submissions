class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> res = new PriorityQueue<>();

        for(int n : stones){
            res.offer(-n);
        }

        while(res.size() > 1){
            int stone1 = res.poll();
            int stone2 = res.poll();

            if(stone2 > stone1) res.offer(stone1 - stone2);
        }

        return res.size() == 0 ? 0 : Math.abs(res.peek());
    }
}
