class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        rig = [0] * len(prices)
        for i in range(len(rig) - 2, -1, -1):
            rig[i] = max(prices[i + 1],rig[i + 1])
        ans = 0
        for i in range(len(prices)):
            tmp = rig[i] - prices[i]
            if tmp < 0:
                continue
            ans = max(ans,tmp)
        return ans