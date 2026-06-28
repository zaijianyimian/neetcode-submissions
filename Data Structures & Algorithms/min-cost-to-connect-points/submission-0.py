class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        visited = [False] * n
        minDist = [float('inf')] * n
        minDist[0] = 0
        ans = 0
        for _ in range(n):
            cur = -1
            for i in range(n):
                if not visited[i] and(cur == -1 or minDist[i] < minDist[cur]):
                    cur = i
            visited[cur] = True
            ans += minDist[cur]
            x1,y1 = points[cur]

            for nxt in range(n):
                if visited[nxt]:
                    continue
                x2,y2 = points[nxt]
                cost = abs(x1 - x2) + abs(y1 - y2)
                minDist[nxt] = min(minDist[nxt],cost)
        return ans