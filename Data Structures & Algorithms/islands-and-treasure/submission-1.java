class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int INF = 2147483647;
        Deque<int[]> queue = new ArrayDeque<>();
        for(int r = 0;r < m;r ++){
            for(int c = 0;c < n;c ++){
                if(grid[r][c] == 0){
                    queue.addLast(new int[]{r,c});
                }
            }
        }
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] tmp = queue.pollFirst();
            int r = tmp[0];
            int c = tmp[1];
            for(int[] direction : directions){
                int nexR = r + direction[0];
                int nexC = c + direction[1];
                if(nexR < 0||nexC < 0 || nexR >= m || nexC >= n || grid[nexR][nexC] != INF){
                    continue;
                }
                queue.addLast(new int[]{nexR,nexC});
                grid[nexR][nexC] = grid[r][c] + 1;
            }
        }
    }
}
