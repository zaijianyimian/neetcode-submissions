class Solution {
    List<String> ans = new ArrayList<>();
    Map<String,PriorityQueue<String>> graph = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        
        for(List<String> ticket : tickets){
            String from = ticket.getFirst();
            String to = ticket.getLast();
            graph.computeIfAbsent(from, key -> new PriorityQueue<>()).offer(to);
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;

    }
    private void dfs(String airport){
        PriorityQueue<String> heap = graph.get(airport);
        while(heap != null && !heap.isEmpty()){
            String newAirport = heap.poll();
            dfs(newAirport);
        }
        ans.add(airport);
    }
}
