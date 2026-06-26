class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i < n;i ++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return dfs(0,-1,graph) && visited.size()  == n;
    }
    public boolean dfs(int node,int parent,List<List<Integer>> graph){
        visited.add(node);
        for(int nextNode : graph.get(node)){
            if(nextNode == parent){
                continue;
            }
            if(visited.contains(nextNode)){
                return false;
            }
            if(!dfs(nextNode,node,graph)){
                return false;
            }
        }
        return true;
    }
}
