class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        total = sum(nums)
        if abs(target) > total:
            return 0
        if (target + total) % 2 != 0:
            return 0
        s = (target + total) // 2
        dp = [0] * (s + 1)
        dp[0] = 1
        for num in nums:
            for j in range(s,num - 1,-1):
                dp[j] += dp[j - num]
        return dp[s]