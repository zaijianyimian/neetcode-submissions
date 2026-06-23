class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        maxHeap = []
        for stone in stones:
            heapq.heappush(maxHeap,-stone)
        while len(maxHeap) > 1:
            stone1 = -heapq.heappop(maxHeap)
            stone2 = -heapq.heappop(maxHeap)
            if stone1 == stone2:
                continue
            heapq.heappush(maxHeap,-(stone1 - stone2))
        if not maxHeap:
            return 0
        return -maxHeap[0]