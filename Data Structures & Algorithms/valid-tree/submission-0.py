class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        # 深度优先遍历，遍历回来就说明不是。
        graph = [[] for _ in range(n)]
        for a,b in edges:
            graph[a].append(b)
            graph[b].append(a)
        visited = set()
        def dfs(node,parent):
            visited.add(node)
            for nextNode in graph[node]:
                if nextNode == parent:
                    continue
                if nextNode in visited:
                    return False
                if not dfs(nextNode,node):
                    return False
            return True
        return dfs(0,-1) and len(visited) == n