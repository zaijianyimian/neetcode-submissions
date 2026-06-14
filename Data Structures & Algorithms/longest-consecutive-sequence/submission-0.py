class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        se = set(nums)
        ans = 0
        for c in se:
            if c - 1 in se:
                continue
            tmp  = 1
            while c + 1 in se:
                tmp += 1
                c += 1
            ans = max(ans,tmp)
        return ans