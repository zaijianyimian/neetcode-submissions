class Solution:
    def jump(self, nums: List[int]) -> int:
        curJump = 0
        maxJump = 0
        ans = 0
        for i in range(len(nums) - 1):
            maxJump = max(maxJump,i + nums[i])
            if curJump == i:
                ans += 1
                curJump = maxJump
        return ans