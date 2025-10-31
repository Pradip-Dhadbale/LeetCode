class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        int rev_no = 0;

        while (temp != 0) {
            int digit = temp % 10;
            rev_no = rev_no * 10 + digit;
            temp = temp / 10;
        } 
       return (x == rev_no);
    }
}
