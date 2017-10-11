// Dynammic Programming
// dp[i] means the largest sum among the subarrays whose last element is A[i]
class Solution {
    public int maxSubArray(int[] nums) {
    int dp[] = new int[nums.length]; int max = nums[0]; dp[0] = nums[0]; 
    for (int i = 1; i < nums.length; i++) {         
        dp[i] = Math.max(dp[i-1] + nums[i] ,nums[i]); // choose: dp[i-1] + A[i]; not choose: A[i]
        max = Math.max(max, dp[i]); // dp[i]: including nums[i], each element has its best sol
                                    // and we are going to choose the best one from these conbination
    }
    return max;
    }
}