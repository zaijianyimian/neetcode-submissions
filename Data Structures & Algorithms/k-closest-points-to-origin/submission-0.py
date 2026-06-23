import heapq
from typing import List

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        min_heap = []

        for x, y in points:
            dist = x * x + y * y
            heapq.heappush(min_heap, (dist, x, y))

        ans = []

        for _ in range(k):
            _, x, y = heapq.heappop(min_heap)
            ans.append([x, y])

        return ans