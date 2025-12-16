class Solution:
    def maxProfit(self, n: int, present: List[int], future: List[int], hierarchy: List[List[int]], budget: int) -> int:
        adj = [[] for _ in range(n)]
        for u, v in hierarchy:
            adj[u - 1].append(v - 1)
            
        def merge(dp1, dp2):
            new_dp = [-1] * (budget + 1)
            for i in range(budget + 1):
                if dp1[i] == -1: continue
                for j in range(budget - i + 1):
                    if dp2[j] == -1: continue
                    new_dp[i + j] = max(new_dp[i + j], dp1[i] + dp2[j])
            return new_dp

        def dfs(u):
            agg_u_bought = [-1] * (budget + 1)
            agg_u_not_bought = [-1] * (budget + 1)
            agg_u_bought[0] = 0
            agg_u_not_bought[0] = 0
            
            for v in adj[u]:
                child_res = dfs(v)
                agg_u_bought = merge(agg_u_bought, child_res[1])
                agg_u_not_bought = merge(agg_u_not_bought, child_res[0])
                
            res_parent_not_bought = list(agg_u_not_bought)
            res_parent_bought = list(agg_u_not_bought)
            
            cost_full = present[u]
            profit_full = future[u] - cost_full
            if cost_full <= budget:
                for b in range(budget - cost_full + 1):
                    if agg_u_bought[b] != -1:
                        res_parent_not_bought[b + cost_full] = max(res_parent_not_bought[b + cost_full], agg_u_bought[b] + profit_full)
            
            cost_half = present[u] // 2
            profit_half = future[u] - cost_half
            if cost_half <= budget:
                for b in range(budget - cost_half + 1):
                    if agg_u_bought[b] != -1:
                        res_parent_bought[b + cost_half] = max(res_parent_bought[b + cost_half], agg_u_bought[b] + profit_half)
            
            cur = 0
            for i in range(budget + 1):
                if res_parent_not_bought[i] > cur: cur = res_parent_not_bought[i]
                res_parent_not_bought[i] = cur
                
            cur = 0
            for i in range(budget + 1):
                if res_parent_bought[i] > cur: cur = res_parent_bought[i]
                res_parent_bought[i] = cur
                
            return (res_parent_not_bought, res_parent_bought)

        return dfs(0)[0][budget]