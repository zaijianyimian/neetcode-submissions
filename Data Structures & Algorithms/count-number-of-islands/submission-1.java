class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '0' || visited[r][c]) {
                    continue;
                }
                queue.addLast(new int[] {r, c});
                visited[r][c] = true;
                while (!queue.isEmpty()) {
                    int[] tmp = queue.pollFirst();
                    int i = tmp[0];
                    int j = tmp[1];
                    for (int[] direction : directions) {
                        int nexI = i + direction[0];
                        int nexJ = j + direction[1];
                        if (nexI < 0 || nexI >= m || nexJ < 0 || nexJ >= n
                            || grid[nexI][nexJ] == '0' || visited[nexI][nexJ]) {
                            continue;
                        } else {
                            queue.addLast(new int[] {nexI, nexJ});
                            visited[nexI][nexJ] = true;
                        }
                    }
                }
                ans += 1;
            }
            
        }
        return ans;
    }

}
