import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        int remainder = 0;

        for (int i = 0; i < nums.length; i++) {
            remainder = (remainder * 2 + nums[i]) % 5;
            
            if (remainder == 0) {
                answer.add(true);
            } else {
                answer.add(false);
            }
        }
        
        return answer;
    }
}