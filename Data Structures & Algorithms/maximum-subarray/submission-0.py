class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        total = nums[0]
        ans = nums[0]
        for i in range(1,len(nums)):
            if total + nums[i] < nums[i]:
                total = nums[i]
            else:
                total += nums[i]
            ans = max(total,ans)
        return ans