class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        m,n = len(grid),len(grid[0])
        queue = deque()
        INF = 2147483647

        directions = {(0,1),(0,-1),(-1,0),(1,0)}
        for r in range(m):
            for c in range(n):
                if grid[r][c] == 0:
                    queue.append((r,c))
        while queue:
            r,c = queue.popleft()
            for dx,dy in directions:
                nexR = r + dx
                nexC = c + dy
                if(nexR < 0  or nexC < 0 or nexR >= m or nexC >= n or grid[nexR][nexC] != INF):
                    continue
                grid[nexR][nexC] = grid[r][c] + 1
                queue.append((nexR,nexC))