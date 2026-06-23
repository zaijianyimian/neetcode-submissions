class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        maxHeap = []
        queue = collections.deque()
        dic = {}
        for c in tasks:
            dic[c] = dic.get(c,0) + 1
        for c in dic.keys():
            heapq.heappush(maxHeap,-dic[c])
        time = 0
        while queue or maxHeap:
            time += 1
            if maxHeap:
                tmp = heapq.heappop(maxHeap)
                tmp += 1
                if tmp != 0:
                    queue.append((time + n,tmp))
            if not queue:
                continue
            else:
                if queue[0][0] == time:
                    _,task = queue.popleft()
                    heapq.heappush(maxHeap,task)
        return time
