class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        su  = sum(nums)
        if su % 2 == 1:
            return False
        target = su // 2
        dp = [False] * (target + 1)
        dp[0] = True
        for i in nums:
            for j in range(target,i - 1,-1):
                dp[j] = dp[j] or dp[j - i]
            if dp[target]:
                return True
        return False
