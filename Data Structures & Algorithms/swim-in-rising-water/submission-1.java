class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // {当前路径最大高度, x, y}
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        heap.offer(new int[]{grid[0][0], 0, 0});

        boolean[][] visited = new boolean[n][n];

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();

            int cost = cur[0];
            int x = cur[1];
            int y = cur[2];

            // 堆里可能有重复状态，已经确定过就跳过
            if (visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            // 第一次从堆中取出终点时，cost 就是最小答案
            if (x == n - 1 && y == n - 1) {
                return cost;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // 越界或已确定最优路径，跳过
                if (nx < 0 || nx >= n || ny < 0 || ny >= n
                        || visited[nx][ny]) {
                    continue;
                }

                // 当前路径经过新格子后的最大高度
                int newCost = Math.max(cost, grid[nx][ny]);

                heap.offer(new int[]{newCost, nx, ny});
            }
        }

        return -1;
    }
}