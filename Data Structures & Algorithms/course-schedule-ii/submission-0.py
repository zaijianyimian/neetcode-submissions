class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(numCourses)]
        inDegree = [0] * numCourses
        for a,b in prerequisites:
            graph[b].append(a)
            inDegree[a] += 1
        queue = deque()
        for course in range(numCourses):
            if inDegree[course] == 0:
                queue.append(course)
        count = 0
        ans = []
        while queue:
            course = queue.popleft()
            ans.append(course)
            count += 1
            for nextCourse in graph[course]:
                inDegree[nextCourse] -= 1
                if inDegree[nextCourse] == 0:
                    queue.append(nextCourse)
        return ans if count == numCourses else [] 