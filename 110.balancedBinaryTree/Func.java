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
    Based on max depth of binary tree, rewrite the func.
    Comparing depth of left node with right one.
*/
public class Solution {
    boolean notBalanced = true;
    int pre_d = 0;
    public int maxDepth(TreeNode node){
        if (node == null) return 0;
        
        /* add a break to terminate recursive quick: notBalanced*/
        int diff = pre_d;
        int left, right;
        
        if(notBalanced == false) return diff;
        
        //diff = 1+Math.max(maxDepth(node.left) , maxDepth(node.right));
        
        /* rewrite */
        
        left = maxDepth(node.left);
        right = maxDepth(node.right);        
        diff = 1+Math.max(left , right);

        pre_d = diff;
        
        //System.out.println("diff: "+ diff + ", node: " + node.val);
        
        //System.out.println("left: " + left + ", right: " + right);
        
        int abs = Math.abs(left - right);
        
        if(abs > 1) notBalanced = false; 
        
        return diff;
    }
    public boolean isBalanced(TreeNode root) {
        
        if( root == null ) return true;
        
        maxDepth(root);
        
        return notBalanced;
    }
}