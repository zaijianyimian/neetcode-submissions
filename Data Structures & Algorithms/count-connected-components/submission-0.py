class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        visited = set()
        ans = 0
        graph = [[] for _ in range(n)]
        for a,b in edges:
            graph[a].append(b)
            graph[b].append(a)
        def dfs(node):
            visited.add(node)
            for nextNode in graph[node]:
                if nextNode in visited:
                    continue
                dfs(nextNode)
        for i in range(n):
            if i in visited:
                continue
            else:
                dfs(i)
                ans += 1
        return ans
            
                