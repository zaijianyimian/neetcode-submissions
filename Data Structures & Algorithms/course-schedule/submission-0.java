class Solution {
    public boolean canFinish(int n, int[][] pres) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] inDegree = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0;i < n;i ++) {
            list.add(new ArrayList<>());
        }
        for(int[] pre: pres){
            int a = pre[0];
            int b = pre[1];
            list.get(b).add(a);
            inDegree[a] ++;
        }

        for(int course = 0;course < n;course++){
            if(inDegree[course] == 0){
                queue.addLast(course);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.pollFirst();
            count ++;
            for(int next:list.get(course)){
                inDegree[next] -- ;
                if(inDegree[next] == 0){
                    queue.addLast(next);
                }
            }
        }
        return count == n;
    }
}
