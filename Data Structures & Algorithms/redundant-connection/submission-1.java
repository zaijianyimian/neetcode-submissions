class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        for(int i = 0;i < n + 1;i ++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            if(hasPath(a,b,new HashSet<>())){
                return new int[]{a,b};
            }
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return new int[]{};
    }

    private boolean hasPath(int a,int b,Set<Integer> set){
        if(a == b){
            return  true;
        }
        set.add(a);
        for(int nxt : graph.get(a)){
            if(!set.contains(nxt)){
                if(hasPath(nxt,b,set)){
                    return true;
                }
            }
        }
        return false;
    }

}
