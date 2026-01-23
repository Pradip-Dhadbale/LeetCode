class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        # Range ensures we don't go out of bounds
        for i in range(len(haystack) - len(needle) + 1):
            # Check if the substring matches the needle
            if haystack[i : i + len(needle)] == needle:
                return i
                
        return -1