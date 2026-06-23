class KthLargest {
        PriorityQueue<Integer> heap;
        int k;
    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;
        for(int num :nums){
            add(num);
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if(heap.size() > k){
            heap.poll();
        }
        return heap.peek();
    }
}
