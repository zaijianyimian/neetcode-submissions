class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0;i <= n;i ++){
            graph.add(new ArrayList<>());
        }
        for(int[] time : times){
            int sourceNode = time[0];
            int targetNode = time[1];
            int weight = time[2];
            graph.get(sourceNode).add(new int[]{targetNode,weight});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        heap.offer(new int[]{0,k});
        int[] dist = new int[n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        while(!heap.isEmpty()){
            int[] tmp = heap.poll();
            int curDist = tmp[0];
            int node = tmp[1];
            if(curDist > dist[node]){
                continue;
            }
            for(int[] arr : graph.get(node)){
                int nextDist = curDist + arr[1];
                if(nextDist < dist[arr[0]]){
                    dist[arr[0]] = nextDist;
                    heap.add(new int[]{nextDist,arr[0]});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1;i < n + 1;i ++){
            ans = Math.max(ans,dist[i]);
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
