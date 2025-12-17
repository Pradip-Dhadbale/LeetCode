class Solution:
    def maximumProfit(self, prices: List[int], k: int) -> int:
        n = len(prices)
        if n < 2:
            return 0
        
        k = min(k, n)
        
        MIN_VAL = -float('inf')
        dp = [[MIN_VAL] * 3 for _ in range(k + 1)]
        dp[0][0] = 0
        
        for p in prices:
            new_dp = [row[:] for row in dp]
            for j in range(1, k + 1):
                if dp[j-1][0] != MIN_VAL:
                    new_dp[j][1] = max(new_dp[j][1], dp[j-1][0] - p)
                if dp[j-1][0] != MIN_VAL:
                    new_dp[j][2] = max(new_dp[j][2], dp[j-1][0] + p)
                if dp[j][1] != MIN_VAL:
                    new_dp[j][0] = max(new_dp[j][0], dp[j][1] + p)
                if dp[j][2] != MIN_VAL:
                    new_dp[j][0] = max(new_dp[j][0], dp[j][2] - p)
            dp = new_dp
            
        return max(row[0] for row in dp)