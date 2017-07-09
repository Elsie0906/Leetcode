/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
    It is a balanced binary tree, but not a binary search tree
    Balances tree:
    1. The left and right subtrees' heights differ by at most one, AND
    2. The left subtree is balanced, AND
    3. The right subtree is balanced
    
    Binary search tree: left < root && right > root for binary search
    
        2
      /   \
    1       3
*/
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        TreeNode newNode = null;
        TreeNode startNode = null;
        
        if( nums.length == 0 )
            return root;
        
        // start
        root = new TreeNode(nums[0]);
        startNode = root;
        
        for(int i=1; i<nums.length; i++){
            
            newNode = new TreeNode(nums[i]);
            
            if( root.left == null && root.right == null ){
                root.left = newNode;
            }else if( root.left != null && root.right != null ){
                root = root.left;
                root.left = newNode;
            }else{
                root.right = newNode;
            } 
        }
        
        return startNode;
    }
}