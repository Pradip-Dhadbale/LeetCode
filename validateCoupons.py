class Solution:
    def validateCoupons(self, code: List[str], businessLine: List[str], isActive: List[bool]) -> List[str]:
        valid_indices = []
        valid_businesses = {"electronics", "grocery", "pharmacy", "restaurant"}
        
        for i in range(len(code)):
            if not isActive[i]:
                continue
            if businessLine[i] not in valid_businesses:
                continue
            if not code[i]:
                continue
            
            is_valid_code = True
            for char in code[i]:
                if not (char.isalnum() or char == '_'):
                    is_valid_code = False
                    break
            
            if is_valid_code:
                valid_indices.append(i)
                
        valid_indices.sort(key=lambda i: (businessLine[i], code[i]))
        
        return [code[i] for i in valid_indices]