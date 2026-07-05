class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        su = sum(nums)
        if su % 2 == 1:
            return False
        target = su // 2
        dp = [False] * (target + 1)
        nextDp = [False] * (target + 1)
        dp[0] = True
        for i in range(len(nums)):
            for j in range(1,target + 1):
                if j >= nums[i]:
                    nextDp[j] = dp[j] or dp[j - nums[i]]
                else:
                    nextDp[j] = dp[j]
            dp,nextDp = nextDp,dp
        return dp[target]