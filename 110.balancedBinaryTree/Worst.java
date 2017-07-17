/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    boolean notBalanced = true;
    int pre_d = 0;
    //int count = 0;
    public int maxDepth(TreeNode node){
        if (node == null) return 0;
        /* add a break to terminate recursive quick: notBalanced*/
        int diff = pre_d;
        
        if(notBalanced == false) return diff;
        
        /*int*/ diff = 1+Math.max(maxDepth(node.left) , maxDepth(node.right));
        pre_d = diff;
        //count++;
        
        //System.out.println("diff: "+ diff + ", node: " + node.val);
        
        //System.out.println("left: " + maxDepth(node.left) + ", right: " + maxDepth(node.right));
        
        int abs = Math.abs(maxDepth(node.left) - maxDepth(node.right));
        
        if(abs > 1) notBalanced = false; 
        
        return diff;
    }
    public boolean isBalanced(TreeNode root) {
        
        if( root == null ) return true;
        
        maxDepth(root);
        //check(root);
        
        //System.out.println("count: " + count);
        //System.out.println("result: " + notBalanced);
        
        return notBalanced;
    }
}