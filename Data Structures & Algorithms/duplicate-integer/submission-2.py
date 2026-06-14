class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        se = set()
        for i in nums:
            if i in se:
                return True
            se.add(i)
        return False