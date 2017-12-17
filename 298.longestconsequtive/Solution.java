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
    public int longestConsecutive(TreeNode root) {
        
        if( root == null)      // empty
            return 0;
        
        // create a new tree, given corresponding val
        // initialize with val = 0
        TreeNode myT = new TreeNode(0);
        
        // traverse & create
        helper(root, myT);
        int max = -1;
        max = traverse(myT);
        
        //System.out.println("max: " + max);
        
        return max+1; // dummy
        
    }
    private int traverse(TreeNode tree){
        /*
        if( tree != null){
            System.out.println(tree.val);
        }
        */
        int left, right;
        
        if( tree.left != null){
            left = traverse(tree.left);
        }
        else
            left = -1;
            
        
        if( tree.right != null){
            right = traverse(tree.right);
        }
        else 
            right = -1;
        
        int max = Math.max(tree.val, left);
        max = Math.max(max, right);
        return max;
            
    }
    private void helper(TreeNode oldT, TreeNode myT){
        
        if( oldT == null)
            return ;
        
        //[debug]
        //System.out.println("helper: " + oldT.val + myT.val)
        
        if( oldT.left != null){
            int x = 0;
            if( oldT.left.val - oldT.val == 1){
                x = myT.val + 1;
            }
            else{
                x = 0;
            }
            TreeNode t = new TreeNode(x);
            myT.left = t;
            helper(oldT.left, t);
        }
        else{
            myT.left = null;
        }
        
        if( oldT.right != null){
            int x = 0;
            if( oldT.right.val - oldT.val == 1){
                x = myT.val + 1;
            }
            
            TreeNode t = new TreeNode(x);
            myT.right = t;
            helper(oldT.right, t);
        }
        else{
            myT.right = null;
        }
    }
}