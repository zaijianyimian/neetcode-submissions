class Solution {
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i < n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] arr : edges){
            int a = arr[0];
            int b = arr[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
            
        }

        int ans = 0;
        for(int i = 0;i < n;i++){
            if(visited.contains(i)){
                continue;
            }else{
                dfs(i,graph);
                ans += 1;
            }
        }
        return ans;
        
    }
    public void dfs(int i,List<List<Integer>> graph){
        visited.add(i);
        for(int nextNode : graph.get(i)){
            if(visited.contains(nextNode)){
                continue;
            }
            dfs(nextNode,graph);
        }
    }
}
