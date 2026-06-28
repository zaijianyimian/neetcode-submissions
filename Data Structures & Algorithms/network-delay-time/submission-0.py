class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = [[] for _ in range(n + 1)]
        for u,v,t in times:
            graph[u].append((v,t))
        dist = [float('inf')] * (n + 1)
        dist[k] = 0
        heap = [(0,k)]
        while heap:
            curDist,node = heapq.heappop(heap)
            if curDist > dist[node]:
                continue
            for nextNode,weight in graph[node]:
                newDist = curDist + weight
                if newDist < dist[nextNode]:
                    dist[nextNode] = newDist
                    heapq.heappush(heap,(newDist,nextNode))
        ans = max(dist[1:])
        return -1 if ans == float('inf') else ans