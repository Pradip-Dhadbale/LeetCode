class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)
        total_happiness = 0
        
        for i in range(k):
            val = happiness[i] - i
            total_happiness += max(0, val)
            
        return total_happiness