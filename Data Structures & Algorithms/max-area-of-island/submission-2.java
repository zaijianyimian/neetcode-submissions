class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0 || visited[r][c]) {
                    continue;
                }
                queue.addLast(new int[] {r, c});
                visited[r][c] = true;
                int tmp = 1;
                while (!queue.isEmpty()) {
                    int[] arr = queue.pollFirst();
                    int x = arr[0];
                    int y = arr[1];
                    for (int[] direction : directions) {
                        int dx = x + direction[0];
                        int dy = y + direction[1];
                        if (dx < 0 || dx >= m || dy < 0 || dy >= n || grid[dx][dy] == 0
                            || visited[dx][dy]) {
                            continue;
                        }
                        queue.addLast(new int[] {dx, dy});
                        tmp += 1;
                        visited[dx][dy] = true;
                    }
                }
                ans = Math.max(ans, tmp);
            }
        }
        return ans;
    }
}
