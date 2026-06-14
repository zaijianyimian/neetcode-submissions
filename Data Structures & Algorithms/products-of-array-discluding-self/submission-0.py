class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        rig = [1] * len(nums)
        for i in range(len(nums) - 2,-1,-1):
            rig[i] = nums[i + 1] * rig[i + 1]
        lef = 1
        ans = []
        for i in range(len(nums)):
            ans.append(lef * rig[i])
            lef *= nums[i]
        return ans
