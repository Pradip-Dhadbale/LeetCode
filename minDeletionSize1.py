class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        n = len(strs)
        m = len(strs[0])
        dp = [1] * m
        
        for i in range(m):
            for j in range(i):
                valid = True
                for row in range(n):
                    if strs[row][j] > strs[row][i]:
                        valid = False
                        break
                if valid:
                    dp[i] = max(dp[i], dp[j] + 1)
                    
        return m - max(dp)