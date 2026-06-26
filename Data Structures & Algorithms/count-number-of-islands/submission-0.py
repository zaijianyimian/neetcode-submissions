class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ans = 0
        m ,n = len(grid),len(grid[0])
        visited = [[False] * n for _ in range(m)]
        directions = {(0,1),(0,-1),(1,0),(-1,0)}
        queue = collections.deque()
        for r in range(m):
            for c in range(n):
                if(grid[r][c] == '0' or visited[r][c]):
                    continue
                queue.append((r,c))
                visited[r][c] = True
                while queue:
                    i,j = queue.popleft()
                    for dx,dy in directions:
                        nexL = i + dx;
                        nexR = j + dy;
                        if (nexL < 0 or nexL  >= m or nexR < 0 or nexR >= n or grid[nexL][nexR] == '0' or  visited[nexL][nexR]):
                            continue
                        else:
                            queue.append((nexL,nexR))
                            visited[nexL][nexR] = True
                ans += 1
        return ans
                        