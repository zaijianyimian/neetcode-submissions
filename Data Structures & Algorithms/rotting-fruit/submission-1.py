class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m,n = len(grid),len(grid[0])
        sum = 0 # 记录所有的
        ans = 0
        num = 0 # 记录已经腐烂的
        queue = collections.deque()
        directions = {(0,1),(0,-1),(1,0),(-1,0)}
        for r in range(m):
            for c in range(n):
                if grid[r][c] == 2:
                    num += 1
                    sum += 1
                    queue.append((r,c))
                elif grid[r][c] == 1:
                    sum += 1

        if sum == 0:
            return 0
        while queue:
            size = len(queue)
            ans += 1
            for tmp in range(size):
                r,c = queue.popleft()
                for dx,dy in directions:
                    nexR = r + dx
                    nexC = c + dy
                    if nexC < 0 or nexC >= n or nexR < 0 or nexR >= m or grid[nexR][nexC] != 1:
                        continue
                    else:
                        grid[nexR][nexC] = 2
                        num += 1
                        queue.append((nexR,nexC))
            
        return ans - 1 if num == sum else -1