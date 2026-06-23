class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        for(int stone : stones){
            maxHeap.offer(stone);
        }
        while(maxHeap.size() > 1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            maxHeap.offer(stone1 - stone2);
        }
        return maxHeap.peek();

    }
}
