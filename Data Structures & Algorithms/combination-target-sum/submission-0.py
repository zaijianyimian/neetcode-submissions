class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        ans = []
        path = []
        def backtrack(nums: List[int],target:int,start:int) -> None:
            nonlocal ans,path
            if(target == 0):
                ans.append(path[:])
                return
            elif target < 0:
                return
            for i in range(start,len(nums)):
                path.append(nums[i])
                backtrack(nums,target - nums[i],i)
                path.remove(nums[i])
        backtrack(nums,target,0)
        return ans
            