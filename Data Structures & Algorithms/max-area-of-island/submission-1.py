class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
         ans = 0
         m,n = len(grid),len(grid[0])
         queue = collections.deque()
         visited = [[False] * n for _ in range(m)]
         directions = {(0,1),(0,-1),(1,0),(-1,0)}
         for r in range(m):
            for c in range(n):
                if grid[r][c] == 0 or visited[r][c]:
                    continue
                queue.append((r,c))
                visited[r][c] = True
                tmp = 1
                while queue:
                    dx,dy = queue.popleft()
                    for direction in directions:
                        x,y = direction
                        nexDx = x + dx
                        nexDy = y + dy
                        if(nexDx < 0 or nexDx >= m or nexDy < 0 or nexDy >= n or grid[nexDx][nexDy] == 0 or visited[nexDx][nexDy]):
                            continue
                        queue.append((nexDx,nexDy))
                        visited[nexDx][nexDy] = True
                        tmp += 1
                ans = max(ans,tmp)
         return ans
                