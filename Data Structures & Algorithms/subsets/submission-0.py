class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        path = []
        def backtrack(nums:List[int],start: int) -> None:
            nonlocal ans
            ans.append(path[:])
            for i in range(start,len(nums),1):
                path.append(nums[i])
                backtrack(nums,i + 1)
                path.remove(nums[i])
        backtrack(nums,0)
        return ans