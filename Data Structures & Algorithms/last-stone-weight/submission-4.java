class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int s : stones){
            minHeap.offer(-s); //Make a max heap
        }

        while(minHeap.size() > 1){
            int stone1 = minHeap.poll();
            int stone2 = minHeap.poll();
            if(stone2 > stone1) minHeap.offer(stone1 - stone2);
        }

        return minHeap.size() == 0 ? 0 : Math.abs(minHeap.peek());
    }
}
