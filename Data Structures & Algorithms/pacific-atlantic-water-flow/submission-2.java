class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return ans;
        }

        int m = heights.length;
        int n = heights[0].length;

        int[][] directions = {
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0}
        };

        // 太平洋：上边界 + 左边界
        boolean[][] ul = new boolean[m][n];
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            queue.addLast(new int[]{i, 0});
            ul[i][0] = true;
        }

        for (int j = 0; j < n; j++) {
            if (!ul[0][j]) {
                queue.addLast(new int[]{0, j});
                ul[0][j] = true;
            }
        }

        bfs(heights, ul, queue, directions);

        // 大西洋：下边界 + 右边界
        boolean[][] rd = new boolean[m][n];
        queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            queue.addLast(new int[]{i, n - 1});
            rd[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            if (!rd[m - 1][j]) {
                queue.addLast(new int[]{m - 1, j});
                rd[m - 1][j] = true;
            }
        }

        bfs(heights, rd, queue, directions);

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (ul[r][c] && rd[r][c]) {
                    ans.add(List.of(r, c));
                }
            }
        }

        return ans;
    }

    private void bfs(
            int[][] heights,
            boolean[][] visited,
            Deque<int[]> queue,
            int[][] directions
    ) {
        int m = heights.length;
        int n = heights[0].length;

        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            int r = cur[0];
            int c = cur[1];

            for (int[] direction : directions) {
                int nextR = r + direction[0];
                int nextC = c + direction[1];

                if (
                    nextR < 0 || nextR >= m ||
                    nextC < 0 || nextC >= n ||
                    visited[nextR][nextC] ||
                    heights[nextR][nextC] < heights[r][c]
                ) {
                    continue;
                }

                visited[nextR][nextC] = true;
                queue.addLast(new int[]{nextR, nextC});
            }
        }
    }
}