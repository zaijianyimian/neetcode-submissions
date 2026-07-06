class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        if n == 0:
            return 0
        dp = [[0] * 2 for _ in range(n)]
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for i in range(1,n):
            dp[i][0] = max(dp[i - 1][0],dp[i - 1][1] + prices[i])
            buy_from = dp[i - 2][0] if i >= 2 else 0
            dp[i][1] = max(dp[i - 1][1], buy_from - prices[i])
        return dp[n - 1][0]