class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        graph = [[] for _ in range(n + 1)]
        def hasPath(start,target,visited):
            if start == target:
                return True
            visited.add(start)
            for nextNode in graph[start]:
                if nextNode not in visited:
                    if hasPath(nextNode,target,visited):
                        return True
            return False
        for a, b in edges:
            if hasPath(a,b,set()):
                return [a,b]
            graph[a].append(b)
            graph[b].append(a)
        return []
        
                

