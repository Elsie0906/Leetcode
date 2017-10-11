/*
** since we are told that we are missing only one number in [1,n], 
** we just need to look at the difference between the sum([1,n]) = n * (n+1) / 2 and the sum of nums in our array.
*/
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int num: nums)
            sum += num;
            
        return (nums.length * (nums.length + 1) )/ 2 - sum;
    }
}