import java.util.*; // Stack

public class Solution {
    public boolean isPalindrome(int x) {
        
        int copy_x = x;   
        int rec_x = 0;
        
        /* exceptional case: -2147447412 */
        if(x < 0)
           return false;
           
        /* using case7: reverse int */   
        
        while(copy_x != 0)
        {
            rec_x = rec_x * 10 + (copy_x % 10);
            copy_x = copy_x / 10;
        }
        
        if(rec_x == x)
           return true;
        else
           return false;
    }
 
    public static void main(String[] args){
        Solution sol;
        int num = 2132;

        sol = new Solution();

        System.out.println("num: " + num);
        System.out.println("isPalindrome: " + sol.isPalindrome(num));
    }
}