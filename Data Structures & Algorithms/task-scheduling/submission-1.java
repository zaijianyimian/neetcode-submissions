class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        Deque<int[]> deque = new ArrayDeque<>();
        Map<Character,Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            maxHeap.offer(entry.getValue());
        }
        int time = 0;
        while(deque.size() > 0 || maxHeap.size() > 0){
            time += 1;
            if (!maxHeap.isEmpty()){
                int tmp = maxHeap.poll();
                tmp -= 1;
                if(tmp > 0)
                deque.addLast(new int[]{time + n,tmp});
            }
            if(!deque.isEmpty()){
                if(time == deque.peekFirst()[0]){
                    int task = deque.pop()[1];
                    maxHeap.offer(task);
                }
            }
        }
        return time;
    }
}
