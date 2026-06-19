class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l,r = 1,max(piles)
        while l <= r:
            totalHour = 0 
            mid = (l + r) // 2
            for num in piles:
                totalHour += (num + mid - 1) // mid
            if totalHour <= h:
                r = mid - 1
            else:
                l = mid + 1
        return l