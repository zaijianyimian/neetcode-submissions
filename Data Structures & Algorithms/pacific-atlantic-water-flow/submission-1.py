class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        if not heights or not heights[0]:
            return []

        m, n = len(heights), len(heights[0])

        directions = {(0, 1), (0, -1), (-1, 0), (1, 0)}

        def bfs(visited, queue):
            while queue:
                r, c = queue.popleft()

                for dx, dy in directions:
                    nexR = dx + r
                    nexC = dy + c

                    if (
                        nexR < 0 or nexR >= m or
                        nexC < 0 or nexC >= n or
                        visited[nexR][nexC] or
                        heights[nexR][nexC] < heights[r][c]
                    ):
                        continue

                    queue.append((nexR, nexC))
                    visited[nexR][nexC] = True

        # 太平洋：上边界 + 左边界
        ul = [[False] * n for _ in range(m)]
        queue = collections.deque()

        for i in range(m):
            queue.append((i, 0))
            ul[i][0] = True

        for j in range(n):
            queue.append((0, j))
            ul[0][j] = True

        bfs(ul, queue)

        # 大西洋：下边界 + 右边界
        rd = [[False] * n for _ in range(m)]
        queue = collections.deque()

        for i in range(m):
            queue.append((i, n - 1))
            rd[i][n - 1] = True

        for j in range(n):
            queue.append((m - 1, j))
            rd[m - 1][j] = True

        bfs(rd, queue)

        ans = []

        for r in range(m):
            for c in range(n):
                if ul[r][c] and rd[r][c]:
                    ans.append([r, c])

        return ans