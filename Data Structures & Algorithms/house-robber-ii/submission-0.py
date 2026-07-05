class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0] 
        return max(self.help(nums[1:]), self.help(nums[:-1]))      
    def help(self,nums: List[int]):
        dp1,dp2 = 0,0
        for i in nums:
            newDp = max(dp1 + i,dp2)
            dp1,dp2 = dp2,newDp
        return dp2
