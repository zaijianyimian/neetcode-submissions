class Solution:
    def canJump(self, nums: List[int]) -> bool:
        maxGet = 0
        for i in range(len(nums)):
            if maxGet < i:
                return False
            maxGet = max(i + nums[i],maxGet)
        return True