class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        pre2 = 1
        pre1 = 2
        for i in range(2,n):
            pre1,pre2 = pre1 + pre2,pre1
        return pre1