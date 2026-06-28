class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        graph = defaultdict(list)
        for frm,to in tickets:
            graph[frm].append(to)
        for frm in graph:
            graph[frm].sort(reverse=True)
        ans = []
        def dfs(airpot):
            while graph[airpot]:
                nextAirPort = graph[airpot].pop()
                dfs(nextAirPort)
            ans.append(airpot)
        dfs("JFK")
        return ans[::-1]