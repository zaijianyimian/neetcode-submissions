class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        ans = []
        path = []
        used = [False] * len(nums)
        nums.sort()
        def backtrack(nums:List[int],start:int)-> None:
            ans.append(path[:])
            for i in range(start,len(nums)):
                if i> start and nums[i] == nums[i - 1]:
                    used[i] = True
                    continue
                path.append(nums[i])
                used[i] = True
                backtrack(nums,i + 1)
                path.remove(nums[i])
                used[i] = False
        backtrack(nums,0)
        return ans
                