class Solution:
    def numberOfWays(self, corridor: str) -> int:
        MOD = 10**9 + 7
        seats = [i for i, c in enumerate(corridor) if c == 'S']
        
        if len(seats) == 0 or len(seats) % 2 != 0:
            return 0
        
        ans = 1
        for i in range(2, len(seats), 2):
            length = seats[i] - seats[i - 1]
            ans = (ans * length) % MOD
            
        return ans