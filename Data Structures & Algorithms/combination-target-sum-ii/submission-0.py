class Solution:
    def combinationSum2(self, nums: List[int], target: int) -> List[List[int]]:
        ans = []
        path = []
        nums.sort()
        def backtrack(nums: List[int],target:int,start:int) -> None:
            nonlocal ans,path
            
            if(target == 0):
                ans.append(path[:])
                return
            elif target < 0:
                return
            for i in range(start,len(nums)):
                if i > start and nums[i] == nums[i - 1]:
                    continue
                path.append(nums[i])
                backtrack(nums,target - nums[i],i + 1)
                path.remove(nums[i])
        backtrack(nums,target,0)
        return ans
            