class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        n = len(strs)
        m = len(strs[0])
        is_sorted = [False] * (n - 1)
        deletions = 0
        
        for j in range(m):
            column_valid = True
            for i in range(n - 1):
                if not is_sorted[i] and strs[i + 1][j] < strs[i][j]:
                    deletions += 1
                    column_valid = False
                    break
            
            if column_valid:
                for i in range(n - 1):
                    if strs[i + 1][j] > strs[i][j]:
                        is_sorted[i] = True
                        
        return deletions