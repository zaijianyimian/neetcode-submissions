class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dic = collections.defaultdict(int)
        freq = [[] for _ in range(len(nums) + 1)] # 否则会发生越界异常
        for i in nums:
            dic[i] += 1
        for ke,v in dic.items():
            freq[v].append(ke)
        ans = []
        for i in range(len(freq) - 1,-1,-1):
            if freq[i] != None:
                ans.extend(freq[i])
                if len(ans) == k:
                    return ans
        return ans
