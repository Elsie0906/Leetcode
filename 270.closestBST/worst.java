/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private double diff = Double.MAX_VALUE;
    private int val = -1;
    public int closestValue(TreeNode root, double target) {
        
        helper(root, target);
        
        return val;
    }
    
    private void helper(TreeNode head, double target){
        
        double res = Math.abs(target - (double)head.val);
        
        if( res < diff){
            diff = res;
            val = head.val;
        }
        
        if( head.left != null){
            helper(head.left, target);
        }
        
        if( head.right != null){
            helper(head.right, target);
        }
    }
}