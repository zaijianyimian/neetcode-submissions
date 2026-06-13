class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        se = set()
        for num in nums:
            if num in se:
                return True
            se.add(num)
        return False