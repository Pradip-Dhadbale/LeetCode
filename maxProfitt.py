class Solution:
    def maxProfit(self, prices: List[int], strategy: List[int], k: int) -> int:
        n = len(prices)
        base_profit = sum(p * s for p, s in zip(prices, strategy))
        
        curr_strat_sum = 0
        curr_sell_sum = 0
        half_k = k // 2
        
        for i in range(k):
            curr_strat_sum += prices[i] * strategy[i]
            if i >= half_k:
                curr_sell_sum += prices[i]
        
        current_imp = curr_sell_sum - curr_strat_sum
        max_imp = max(0, current_imp)
        
        for i in range(1, n - k + 1):
            prev = i - 1
            curr = i + k - 1
            
            curr_strat_sum -= prices[prev] * strategy[prev]
            curr_strat_sum += prices[curr] * strategy[curr]
            
            curr_sell_sum -= prices[prev + half_k]
            curr_sell_sum += prices[curr]
            
            current_imp = curr_sell_sum - curr_strat_sum
            max_imp = max(max_imp, current_imp)
            
        return base_profit + max_imp