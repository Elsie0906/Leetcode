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
    public int countNodes(TreeNode root) {
        
        if( root == null)
            return 0;
        
        return helper(root, 1);     // DFS
    }
    
    private int helper(TreeNode root, int val){
        
        //System.out.println("val: " + val + ", root.val: "+ root.val);
        
        if( root.left == null && root.right == null)
            return val;
        
        if( root.left != null){
            val = helper(root.left, ++val);
        }
        
        if( root.right != null){
            val = helper(root.right, ++val);
        }
            
        return val;
    }
}