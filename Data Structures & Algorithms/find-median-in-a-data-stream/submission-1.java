class MedianFinder {
    private PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        // left: 1 3
        // right: 2
        left.offer(num);
        right.offer(left.poll());
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        
        int totalSize = left.size() + right.size();
        if( totalSize % 2 == 0) {
            return 0.5 * (left.peek() + right.peek());
        } else {
            return left.peek();
        }
    }
}