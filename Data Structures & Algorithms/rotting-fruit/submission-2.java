
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int sum = 0; // 记录所有橘子
        int ans = 0;
        int num = 0; // 记录已经腐烂的橘子

        Deque<int[]> queue = new ArrayDeque<>();

        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) {
                    num++;
                    sum++;
                    queue.addLast(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    sum++;
                }
            }
        }

        // 没有橘子
        if (sum == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] cur = queue.pollFirst();
                int r = cur[0];
                int c = cur[1];

                for (int[] direction : directions) {
                    int nextR = r + direction[0];
                    int nextC = c + direction[1];

                    if (
                        nextR < 0 || nextR >= m ||
                        nextC < 0 || nextC >= n ||
                        grid[nextR][nextC] != 1
                    ) {
                        continue;
                    }

                    grid[nextR][nextC] = 2;
                    num++;
                    queue.addLast(new int[]{nextR, nextC});
                }
            }
        }

        return num == sum ? ans - 1 : -1;
    }
}