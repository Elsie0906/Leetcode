/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // DFS
        boolean result = false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        TreeNode head = root;
        
        while(root != null){
            //System.out.println("val: " + root.val);
        
            // check value
            if( root.left == null && root.right == null && root.val == sum){
                return true;
            }
            
            if( root.left != null){
                root.left.val = root.val + root.left.val;
                queue.add(root.left);
            }
                
            if( root.right != null){
                root.right.val = root.right.val + root.val;
                queue.add(root.right);
            }
            
            if( !queue.isEmpty())
                root = queue.remove(); 
            else
                root = null;
        }
        
        
        return result;
    }
}