class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        ans = []
        path = []
        used = [False] * len(nums)
        def backtrack(nums:List[int]):
            nonlocal ans,path,used
            if len(path) == len(nums):
                ans.append(path[:])
            for i in range(len(nums)):
                if used[i]:
                    continue
                else:
                    path.append(nums[i])
                    used[i] = True
                    backtrack(nums)
                    path.remove(nums[i])
                    used[i] = False
        backtrack(nums)
        return ans